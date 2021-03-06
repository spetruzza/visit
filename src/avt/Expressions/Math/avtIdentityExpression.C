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
//                               avtIdentityExpression.C                     //
// ************************************************************************* //

#include <avtIdentityExpression.h>

#include <vtkDataArray.h>
#include <vtkDataSet.h>


// ****************************************************************************
//  Method: avtIdentityExpression constructor
//
//  Purpose:
//      Defines the constructor.  Note: this should not be inlined in the
//      header because it causes problems for certain compilers.
//
//  Programmer: Hank Childs
//  Creation:   February 5, 2004
//
// ****************************************************************************

avtIdentityExpression::avtIdentityExpression()
{
    ;
}


// ****************************************************************************
//  Method: avtIdentityExpression destructor
//
//  Purpose:
//      Defines the destructor.  Note: this should not be inlined in the header
//      because it causes problems for certain compilers.
//
//  Programmer: Hank Childs
//  Creation:   February 5, 2004
//
// ****************************************************************************

avtIdentityExpression::~avtIdentityExpression()
{
    ;
}


// ****************************************************************************
//  Method: avtIdentityExpression::DoOperation
//
//  Purpose:
//      Copies each component, tuple of a data array.
//
//  Arguments:
//      in            The input data array.
//      out           The output data array.
//      ncomponents   The number of components ('1' for scalar, '2' or '3' for
//                    vectors, etc.)
//      ntuples       The number of tuples (ie 'npoints' or 'ncells')
//
//  Programmer: Hank Childs
//  Creation:   December 9, 2003
//
//  Modifications:
//
//    Hank Childs, Fri Sep 14 11:45:55 PDT 2007
//    Do not assume that the input variable is valid.  If someone makes
//    the expression "d = quadmesh2d", we will end up here with a NULL
//    input.
//
// ****************************************************************************
 
void
avtIdentityExpression::DoOperation(vtkDataArray *in, vtkDataArray *out,
                                   int ncomponents, int ntuples)
{
    void *out_ptr = out->GetVoidPointer(0);

    if( in == NULL )
    {
        size_t numToCopy = out->GetDataTypeSize() * out->GetNumberOfComponents() * out->GetNumberOfTuples();
        memset(out_ptr, 0, numToCopy);
    }
    else if(in->GetDataType() == out->GetDataType())
    {
        void *in_ptr = in->GetVoidPointer(0);
        size_t numToCopy = in->GetDataTypeSize() * in->GetNumberOfComponents() * in->GetNumberOfTuples();
        memcpy(out_ptr, in_ptr, numToCopy);
    }
    else
    {
        for(int i = 0; i < ntuples; ++i)
            for(int j = 0; j < ncomponents; ++j)
                out->SetComponent(i, j, in->GetComponent(i, j));
    }
}

