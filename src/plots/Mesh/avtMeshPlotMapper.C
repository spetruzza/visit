/*****************************************************************************
*
* Copyright (c) 2000 - 2019, Lawrence Livermore National Security, LLC
* Produced at the Lawrence Livermore National Laboratory
* LLNL-CODE-442911
* All rights reserved.
*
* This file is  part of VisIt. For  details, see https://visit.llnl.gov/.  The
* full copyright notice is contained in the file COPYRIGHT located at the root
* of the VisIt distribution or at http://www.llnl.gov/visit/copyright.html.
*
* Redistribution  and  use  in  source  and  binary  forms,  with  or  without
* modification, are permitted provided that the following conditions are met:
*
*  - Redistributions of  source code must  retain the above  copyright notice,
*    this list of conditions and the disclaimer below.
*  - Redistributions in binary form must reproduce the above copyright notice,
*    this  list of  conditions  and  the  disclaimer (as noted below)  in  the
*    documentation and/or other materials provided with the distribution.
*  - Neither the name of  the LLNS/LLNL nor the names of  its contributors may
*    be used to endorse or promote products derived from this software without
*    specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT  HOLDERS AND CONTRIBUTORS "AS IS"
* AND ANY EXPRESS OR  IMPLIED WARRANTIES, INCLUDING,  BUT NOT  LIMITED TO, THE
* IMPLIED WARRANTIES OF MERCHANTABILITY AND  FITNESS FOR A PARTICULAR  PURPOSE
* ARE  DISCLAIMED. IN  NO EVENT  SHALL LAWRENCE  LIVERMORE NATIONAL  SECURITY,
* LLC, THE  U.S.  DEPARTMENT OF  ENERGY  OR  CONTRIBUTORS BE  LIABLE  FOR  ANY
* DIRECT,  INDIRECT,   INCIDENTAL,   SPECIAL,   EXEMPLARY,  OR   CONSEQUENTIAL
* DAMAGES (INCLUDING, BUT NOT  LIMITED TO, PROCUREMENT OF  SUBSTITUTE GOODS OR
* SERVICES; LOSS OF  USE, DATA, OR PROFITS; OR  BUSINESS INTERRUPTION) HOWEVER
* CAUSED  AND  ON  ANY  THEORY  OF  LIABILITY,  WHETHER  IN  CONTRACT,  STRICT
* LIABILITY, OR TORT  (INCLUDING NEGLIGENCE OR OTHERWISE)  ARISING IN ANY  WAY
* OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
* DAMAGE.
*
*****************************************************************************/

// ************************************************************************* //
//                        avtMeshPlotMapper.C                                //
// ************************************************************************* //

#include <avtMeshPlotMapper.h>

#include <vtkActor.h>
#include <vtkDataSetMapper.h>
#include <vtkProperty.h>

#include <avtTransparencyActor.h>

#include <DebugStream.h>
#include <NoInputException.h>


#include <vector>
#include <string>

using std::string;
using std::vector;

// ****************************************************************************
//  Method: avtMeshPlotMapper constructor
//
//  Programmer: Kathleen Biagas
//  Creation:   June 30, 2016
//
//  Modifications:
//
// ****************************************************************************

avtMeshPlotMapper::avtMeshPlotMapper()
{
    lineWidth = 1;
    linesColor[0] = linesColor[1] = linesColor[2] = 0.;
    polysColor[0] = polysColor[1] = polysColor[2] = 1.;
    opacity = 1.;
    surfaceVis = true;
}


// ****************************************************************************
//  Method: avtMeshPlotMapper destructor
//
//  Programmer: Kathleen Biagas
//  Creation:   June 30, 2016
//
// ****************************************************************************

avtMeshPlotMapper::~avtMeshPlotMapper()
{
}


// ****************************************************************************
//  Method: avtMeshPlotMapper::CustomizeMappers
//
//  Purpose:
//     Sets up vtkMappers/vtkActors differently depending upon whether
//     they are the polys (opaque surface) or the lines (the mesh).
//
//  Programmer: Kathleen Biagas
//  Creation:   June 30, 2016
//
// ****************************************************************************

void
avtMeshPlotMapper::CustomizeMappers()
{
    for (int i = 0; i < nMappers; ++i)
    {
        if (mappers[i] == NULL)
            continue;

        mappers[i]->SetScalarVisibility(false);
        vtkProperty *prop = actors[i]->GetProperty();

        // properties for lines and surfaces
        prop->SetAmbient(1.);
        prop->SetDiffuse(0.);

        if (labels[i].compare(0, 6, string("lines_")) == 0)
        {
            prop->SetColor(linesColor);
            prop->SetLineWidth(lineWidth);
            prop->SetOpacity(opacity);
        }
        else if (labels[i].compare(0, 6, string("polys_")) == 0)
        {
            // this is to satisfy avtTransparencyActor which does
            // not differentiate properties from different actors
            prop->SetLineWidth(lineWidth);
            actors[i]->SetVisibility(surfaceVis);
            prop->SetColor(polysColor);
        }
    }
}


// ****************************************************************************
//  Method: avtMeshPlotMapper::SetSurfaceVisibility
//
//  Purpose:
//      Toggles surface visibility.
//
//  Programmer: Kathleen Biagas
//  Creation:   June 16, 2016
//
//  Modifications:
//
// ****************************************************************************

void
avtMeshPlotMapper::SetSurfaceVisibility(bool val)
{
    if (surfaceVis != val)
    {
        surfaceVis = val;
        vector<int> v(nMappers);
        for (int i = 0; i < nMappers; ++i)
        {
            v[i] = 1;
            if (actors[i] != NULL)
            {
                if (labels[i].compare(0, 6, string("polys_")) == 0)
                {
                    actors[i]->SetVisibility(surfaceVis);
                    v[i] = surfaceVis ? 1 : 0;
                }
            }
        }
        // need to tell the transparencyActor that visibility changed
        if (transparencyActor != NULL)
        {
            transparencyActor->ReplaceActorVisibility(transparencyIndex, v);
            NotifyTransparencyActor();
        }

        for (int i = 0; i < nMappers; ++i)
        {
            if (mappers[i] != NULL)
            {
                mappers[i]->Modified();
                actors[i]->Modified();
            }
        }
    }
}

// ****************************************************************************
//  Method: ColorsAreDifferent
//
//  Purpose:
//     Helper method for comparing rgb colors.
//
//  Programmer: Kathleen Biagas
//  Creation:   June 30, 2016
//
// ****************************************************************************

static bool
ColorsAreDifferent(double a[3], double b[3])
{
   return ((a[0] != b[0]) ||
           (a[1] != b[1]) ||
           (a[2] != b[2]));
}


// ****************************************************************************
//  Method: avtMeshPlotMapper::SetMeshColor
//
//  Purpose:
//     Sets color for mesh lines.
//
//  Programmer: Kathleen Biagas
//  Creation:   June 30, 2016
//
// ****************************************************************************

void
avtMeshPlotMapper::SetMeshColor(double rgb[3])
{
    if (ColorsAreDifferent(linesColor, rgb))
    {
        linesColor[0] = rgb[0];
        linesColor[1] = rgb[1];
        linesColor[2] = rgb[2];
        for (int i = 0; i < nMappers; ++i)
        {
            if (actors[i] != NULL && !labels.empty() &&
                labels[i].compare(0, 6, string("lines_")) == 0)
            {
                actors[i]->GetProperty()->SetColor(rgb);
            }
        }
        NotifyTransparencyActor();
    }
}


// ****************************************************************************
//  Method: avtMeshPlotMapper::SetSurfaceColor
//
//  Purpose:
//     Sets color to be used for the opaque surface.
//
//
//  Programmer: Kathleen Biagas
//  Creation:   June 30, 2016
//
// ****************************************************************************

void
avtMeshPlotMapper::SetSurfaceColor(double rgb[3])
{
    if (ColorsAreDifferent(polysColor, rgb))
    {
        polysColor[0] = rgb[0];
        polysColor[1] = rgb[1];
        polysColor[2] = rgb[2];
        for (int i = 0; i < nMappers; ++i)
        {
            if (actors[i] != NULL && !labels.empty() &&
                labels[i].compare(0, 6, string("polys_")) == 0)
            {
                actors[i]->GetProperty()->SetColor(rgb);
            }
        }
        NotifyTransparencyActor();
    }
}


// ****************************************************************************
//  Method: avtMeshPlotMapper::SetOpacity
//
//  Purpose:
//     Sets the opacity.
//
//  Programmer: Kathleen Biagas
//  Creation:   June 30, 2016
//
// ****************************************************************************

void
avtMeshPlotMapper::SetOpacity(double val)
{
    if (opacity != val)
    {
        opacity = val;
        for (int i = 0; i < nMappers; ++i)
        {
            if (actors[i] != NULL)
            {
                actors[i]->GetProperty()->SetOpacity(opacity);
            }
        }
        NotifyTransparencyActor();
    }
}


// ****************************************************************************
//  Method: avtMeshPlotMapper::SetLineWidth
//
//  Purpose:
//     Sets the line width.
//
//  Programmer: Kathleen Biagas
//  Creation:   June 30, 2016
//
// ****************************************************************************

void
avtMeshPlotMapper::SetLineWidth(int lw)
{
    if (lineWidth != lw)
    {
        lineWidth = lw;
        for (int i = 0; i < nMappers; ++i)
        {
            // should not need to set this for polys, but avtTransparencyActor
            // doesn't handle properties correctly in this instance, so set
            // line width for all actors
            //if (actors[i] != NULL && !labels.empty() && labels[i] == "lines_")

            if (actors[i] != NULL)
            {
                actors[i]->GetProperty()->SetLineWidth(lw);
            }
        }
        NotifyTransparencyActor();
    }
}


// ****************************************************************************
//  Method: avtMeshPlotMapper::NotifyTransparencyActor
//
//  Purpose:
//    Informs the transparency actor that its input has changed.
//
//  Programmer: Kathleen Biagas
//  Creation:   July 11, 2016
//
//  Modifications:
//
// ****************************************************************************

void
avtMeshPlotMapper::NotifyTransparencyActor()
{
    if (transparencyActor != NULL)
    {
        transparencyActor->InputWasModified(transparencyIndex);
        transparencyActor->InvalidateTransparencyCache();
    }
}


// ****************************************************************************
//  Method: avtMeshPlotMapper::SetLabels
//
//  Purpose:
//     Saves the labels coming from the input data tree.
//
//  Programmer: Kathleen Biagas
//  Creation:   June 30, 2016
//
// ****************************************************************************

void
avtMeshPlotMapper::SetLabels(vector<string> &l, bool fromTree)
{
    if (!fromTree)
        return;

    if (l.empty())
    {
        debug1 << "avtMeshPlotMapper expects labels in the input tree." << endl;
        EXCEPTION0(NoInputException);
    }
    else
    {
       labels = l;
    }
}


// ****************************************************************************
//  Method: avtMeshPlotMapper::ActorIsShiftable
//
//  Purpose:
//     Only the lines portion of the Mesh plot should be shifted.
//
//  Programmer: Kathleen Biagas
//  Creation:   April 26, 2018
//
// ****************************************************************************

bool
avtMeshPlotMapper::ActorIsShiftable(int i)
{
    bool shiftable = true;
    if (!labels.empty() && i >= 0 && i < labels.size())
        shiftable &= (labels[i].compare(0, 6, string("lines_")) == 0);
    return shiftable;
}
