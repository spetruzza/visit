/*****************************************************************************
*
* Copyright (c) 2000 - 2010, Lawrence Livermore National Security, LLC
* Produced at the Lawrence Livermore National Laboratory
* LLNL-CODE-400124
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
//                                 avtPoincarePlot.h                             //
// ************************************************************************* //

#ifndef AVT_Poincare_PLOT_H
#define AVT_Poincare_PLOT_H


#include <avtLegend.h>
#include <avtPlot.h>

#include <PoincareAttributes.h>

class     avtLookupTable;
class     avtVariableLegend;
class     avtVariableMapper;
class     avtPoincareFilter;

// ****************************************************************************
//  Class:  avtPoincarePlot
//
//  Purpose:
//      A concrete type of avtPlot, this is the Poincare plot.
//
//  Programmer: dpn -- generated by xml2avt
//  Creation:   Tue Oct 7 09:02:52 PDT 2008
//
// ****************************************************************************

class avtPoincarePlot : public avtLineDataPlot
{
  public:
                                avtPoincarePlot();
    virtual                    ~avtPoincarePlot();

    virtual const char         *GetName(void) { return "PoincarePlot"; };

    static avtPlot             *Create();

    virtual void                SetAtts(const AttributeGroup*);

  protected:
    PoincareAttributes          atts;

    avtVariableMapper          *varMapper;
    avtVariableLegend          *varLegend;
    avtLegend_p                 varLegendRefPtr;
    avtLookupTable             *avtLUT;
    avtPoincareFilter          *poincareFilter;

    virtual avtMapper          *GetMapper(void);
    virtual avtDataObject_p     ApplyOperators(avtDataObject_p);
    virtual avtDataObject_p     ApplyRenderingTransformation(avtDataObject_p);
    virtual void                CustomizeBehavior(void);
    virtual void                CustomizeMapper(avtDataObjectInformation &);
    virtual avtContract_p       EnhanceSpecification(avtContract_p in_contract);

    virtual avtLegend_p         GetLegend(void) { return varLegendRefPtr; }
    void                        SetLegend(bool legendOn);
    void                        SetLegendRanges();

};


#endif