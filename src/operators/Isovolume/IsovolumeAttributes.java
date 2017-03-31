// ***************************************************************************
//
// Copyright (c) 2000 - 2017, Lawrence Livermore National Security, LLC
// Produced at the Lawrence Livermore National Laboratory
// LLNL-CODE-442911
// All rights reserved.
//
// This file is  part of VisIt. For  details, see https://visit.llnl.gov/.  The
// full copyright notice is contained in the file COPYRIGHT located at the root
// of the VisIt distribution or at http://www.llnl.gov/visit/copyright.html.
//
// Redistribution  and  use  in  source  and  binary  forms,  with  or  without
// modification, are permitted provided that the following conditions are met:
//
//  - Redistributions of  source code must  retain the above  copyright notice,
//    this list of conditions and the disclaimer below.
//  - Redistributions in binary form must reproduce the above copyright notice,
//    this  list of  conditions  and  the  disclaimer (as noted below)  in  the
//    documentation and/or other materials provided with the distribution.
//  - Neither the name of  the LLNS/LLNL nor the names of  its contributors may
//    be used to endorse or promote products derived from this software without
//    specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT  HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR  IMPLIED WARRANTIES, INCLUDING,  BUT NOT  LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND  FITNESS FOR A PARTICULAR  PURPOSE
// ARE  DISCLAIMED. IN  NO EVENT  SHALL LAWRENCE  LIVERMORE NATIONAL  SECURITY,
// LLC, THE  U.S.  DEPARTMENT OF  ENERGY  OR  CONTRIBUTORS BE  LIABLE  FOR  ANY
// DIRECT,  INDIRECT,   INCIDENTAL,   SPECIAL,   EXEMPLARY,  OR   CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT  LIMITED TO, PROCUREMENT OF  SUBSTITUTE GOODS OR
// SERVICES; LOSS OF  USE, DATA, OR PROFITS; OR  BUSINESS INTERRUPTION) HOWEVER
// CAUSED  AND  ON  ANY  THEORY  OF  LIABILITY,  WHETHER  IN  CONTRACT,  STRICT
// LIABILITY, OR TORT  (INCLUDING NEGLIGENCE OR OTHERWISE)  ARISING IN ANY  WAY
// OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
// DAMAGE.
//
// ***************************************************************************

package llnl.visit.operators;

import llnl.visit.AttributeSubject;
import llnl.visit.CommunicationBuffer;
import llnl.visit.Plugin;

// ****************************************************************************
// Class: IsovolumeAttributes
//
// Purpose:
//    This class contains attributes for the isovolume operator.
//
// Notes:      Autogenerated by xml2java.
//
// Programmer: xml2java
// Creation:   omitted
//
// Modifications:
//   
// ****************************************************************************

public class IsovolumeAttributes extends AttributeSubject implements Plugin
{
    private static int IsovolumeAttributes_numAdditionalAtts = 3;

    public IsovolumeAttributes()
    {
        super(IsovolumeAttributes_numAdditionalAtts);

        lbound = -1e+37;
        ubound = 1e+37;
        variable = new String("default");
    }

    public IsovolumeAttributes(int nMoreFields)
    {
        super(IsovolumeAttributes_numAdditionalAtts + nMoreFields);

        lbound = -1e+37;
        ubound = 1e+37;
        variable = new String("default");
    }

    public IsovolumeAttributes(IsovolumeAttributes obj)
    {
        super(obj);

        lbound = obj.lbound;
        ubound = obj.ubound;
        variable = new String(obj.variable);

        SelectAll();
    }

    public int Offset()
    {
        return super.Offset() + super.GetNumAdditionalAttributes();
    }

    public int GetNumAdditionalAttributes()
    {
        return IsovolumeAttributes_numAdditionalAtts;
    }

    public boolean equals(IsovolumeAttributes obj)
    {
        // Create the return value
        return ((lbound == obj.lbound) &&
                (ubound == obj.ubound) &&
                (variable.equals(obj.variable)));
    }

    public String GetName() { return "Isovolume"; }
    public String GetVersion() { return "1.0"; }

    // Property setting methods
    public void SetLbound(double lbound_)
    {
        lbound = lbound_;
        Select(0);
    }

    public void SetUbound(double ubound_)
    {
        ubound = ubound_;
        Select(1);
    }

    public void SetVariable(String variable_)
    {
        variable = variable_;
        Select(2);
    }

    // Property getting methods
    public double GetLbound() { return lbound; }
    public double GetUbound() { return ubound; }
    public String GetVariable() { return variable; }

    // Write and read methods.
    public void WriteAtts(CommunicationBuffer buf)
    {
        if(WriteSelect(0, buf))
            buf.WriteDouble(lbound);
        if(WriteSelect(1, buf))
            buf.WriteDouble(ubound);
        if(WriteSelect(2, buf))
            buf.WriteString(variable);
    }

    public void ReadAtts(int index, CommunicationBuffer buf)
    {
        switch(index)
        {
        case 0:
            SetLbound(buf.ReadDouble());
            break;
        case 1:
            SetUbound(buf.ReadDouble());
            break;
        case 2:
            SetVariable(buf.ReadString());
            break;
        }
    }

    public String toString(String indent)
    {
        String str = new String();
        str = str + doubleToString("lbound", lbound, indent) + "\n";
        str = str + doubleToString("ubound", ubound, indent) + "\n";
        str = str + stringToString("variable", variable, indent) + "\n";
        return str;
    }


    // Attributes
    private double lbound;
    private double ubound;
    private String variable;
}

