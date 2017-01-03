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
// Class: RevolveAttributes
//
// Purpose:
//    This class contains attributes for the revolve operator.
//
// Notes:      Autogenerated by xml2java.
//
// Programmer: xml2java
// Creation:   omitted
//
// Modifications:
//   
// ****************************************************************************

public class RevolveAttributes extends AttributeSubject implements Plugin
{
    private static int RevolveAttributes_numAdditionalAtts = 6;

    // Enum values
    public final static int MESHTYPE_AUTO = 0;
    public final static int MESHTYPE_XY = 1;
    public final static int MESHTYPE_RZ = 2;
    public final static int MESHTYPE_ZR = 3;


    public RevolveAttributes()
    {
        super(RevolveAttributes_numAdditionalAtts);

        meshType = MESHTYPE_AUTO;
        autoAxis = true;
        axis = new double[3];
        axis[0] = 1;
        axis[1] = 0;
        axis[2] = 0;
        startAngle = 0;
        stopAngle = 360;
        steps = 30;
    }

    public RevolveAttributes(int nMoreFields)
    {
        super(RevolveAttributes_numAdditionalAtts + nMoreFields);

        meshType = MESHTYPE_AUTO;
        autoAxis = true;
        axis = new double[3];
        axis[0] = 1;
        axis[1] = 0;
        axis[2] = 0;
        startAngle = 0;
        stopAngle = 360;
        steps = 30;
    }

    public RevolveAttributes(RevolveAttributes obj)
    {
        super(RevolveAttributes_numAdditionalAtts);

        int i;

        meshType = obj.meshType;
        autoAxis = obj.autoAxis;
        axis = new double[3];
        axis[0] = obj.axis[0];
        axis[1] = obj.axis[1];
        axis[2] = obj.axis[2];

        startAngle = obj.startAngle;
        stopAngle = obj.stopAngle;
        steps = obj.steps;

        SelectAll();
    }

    public int Offset()
    {
        return super.Offset() + super.GetNumAdditionalAttributes();
    }

    public int GetNumAdditionalAttributes()
    {
        return RevolveAttributes_numAdditionalAtts;
    }

    public boolean equals(RevolveAttributes obj)
    {
        int i;

        // Compare the axis arrays.
        boolean axis_equal = true;
        for(i = 0; i < 3 && axis_equal; ++i)
            axis_equal = (axis[i] == obj.axis[i]);

        // Create the return value
        return ((meshType == obj.meshType) &&
                (autoAxis == obj.autoAxis) &&
                axis_equal &&
                (startAngle == obj.startAngle) &&
                (stopAngle == obj.stopAngle) &&
                (steps == obj.steps));
    }

    public String GetName() { return "Revolve"; }
    public String GetVersion() { return "1.0"; }

    // Property setting methods
    public void SetMeshType(int meshType_)
    {
        meshType = meshType_;
        Select(0);
    }

    public void SetAutoAxis(boolean autoAxis_)
    {
        autoAxis = autoAxis_;
        Select(1);
    }

    public void SetAxis(double[] axis_)
    {
        axis[0] = axis_[0];
        axis[1] = axis_[1];
        axis[2] = axis_[2];
        Select(2);
    }

    public void SetAxis(double e0, double e1, double e2)
    {
        axis[0] = e0;
        axis[1] = e1;
        axis[2] = e2;
        Select(2);
    }

    public void SetStartAngle(double startAngle_)
    {
        startAngle = startAngle_;
        Select(3);
    }

    public void SetStopAngle(double stopAngle_)
    {
        stopAngle = stopAngle_;
        Select(4);
    }

    public void SetSteps(int steps_)
    {
        steps = steps_;
        Select(5);
    }

    // Property getting methods
    public int      GetMeshType() { return meshType; }
    public boolean  GetAutoAxis() { return autoAxis; }
    public double[] GetAxis() { return axis; }
    public double   GetStartAngle() { return startAngle; }
    public double   GetStopAngle() { return stopAngle; }
    public int      GetSteps() { return steps; }

    // Write and read methods.
    public void WriteAtts(CommunicationBuffer buf)
    {
        if(WriteSelect(0, buf))
            buf.WriteInt(meshType);
        if(WriteSelect(1, buf))
            buf.WriteBool(autoAxis);
        if(WriteSelect(2, buf))
            buf.WriteDoubleArray(axis);
        if(WriteSelect(3, buf))
            buf.WriteDouble(startAngle);
        if(WriteSelect(4, buf))
            buf.WriteDouble(stopAngle);
        if(WriteSelect(5, buf))
            buf.WriteInt(steps);
    }

    public void ReadAtts(int index, CommunicationBuffer buf)
    {
        switch(index)
        {
        case 0:
            SetMeshType(buf.ReadInt());
            break;
        case 1:
            SetAutoAxis(buf.ReadBool());
            break;
        case 2:
            SetAxis(buf.ReadDoubleArray());
            break;
        case 3:
            SetStartAngle(buf.ReadDouble());
            break;
        case 4:
            SetStopAngle(buf.ReadDouble());
            break;
        case 5:
            SetSteps(buf.ReadInt());
            break;
        }
    }

    public String toString(String indent)
    {
        String str = new String();
        str = str + indent + "meshType = ";
        if(meshType == MESHTYPE_AUTO)
            str = str + "MESHTYPE_AUTO";
        if(meshType == MESHTYPE_XY)
            str = str + "MESHTYPE_XY";
        if(meshType == MESHTYPE_RZ)
            str = str + "MESHTYPE_RZ";
        if(meshType == MESHTYPE_ZR)
            str = str + "MESHTYPE_ZR";
        str = str + "\n";
        str = str + boolToString("autoAxis", autoAxis, indent) + "\n";
        str = str + doubleArrayToString("axis", axis, indent) + "\n";
        str = str + doubleToString("startAngle", startAngle, indent) + "\n";
        str = str + doubleToString("stopAngle", stopAngle, indent) + "\n";
        str = str + intToString("steps", steps, indent) + "\n";
        return str;
    }


    // Attributes
    private int      meshType;
    private boolean  autoAxis;
    private double[] axis;
    private double   startAngle;
    private double   stopAngle;
    private int      steps;
}

