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
// Class: DataBinningAttributes
//
// Purpose:
//    The attributes for the DataBinning operator
//
// Notes:      Autogenerated by xml2java.
//
// Programmer: xml2java
// Creation:   omitted
//
// Modifications:
//   
// ****************************************************************************

public class DataBinningAttributes extends AttributeSubject implements Plugin
{
    private static int DataBinningAttributes_numAdditionalAtts = 25;

    // Enum values
    public final static int REDUCTIONOPERATOR_AVERAGE = 0;
    public final static int REDUCTIONOPERATOR_MINIMUM = 1;
    public final static int REDUCTIONOPERATOR_MAXIMUM = 2;
    public final static int REDUCTIONOPERATOR_STANDARDDEVIATION = 3;
    public final static int REDUCTIONOPERATOR_VARIANCE = 4;
    public final static int REDUCTIONOPERATOR_SUM = 5;
    public final static int REDUCTIONOPERATOR_COUNT = 6;
    public final static int REDUCTIONOPERATOR_RMS = 7;
    public final static int REDUCTIONOPERATOR_PDF = 8;

    public final static int NUMDIMENSIONS_ONE = 0;
    public final static int NUMDIMENSIONS_TWO = 1;
    public final static int NUMDIMENSIONS_THREE = 2;

    public final static int OUTOFBOUNDSBEHAVIOR_CLAMP = 0;
    public final static int OUTOFBOUNDSBEHAVIOR_DISCARD = 1;

    public final static int BINBASEDON_X = 0;
    public final static int BINBASEDON_Y = 1;
    public final static int BINBASEDON_Z = 2;
    public final static int BINBASEDON_VARIABLE = 3;

    public final static int OUTPUTTYPE_OUTPUTONBINS = 0;
    public final static int OUTPUTTYPE_OUTPUTONINPUTMESH = 1;


    public DataBinningAttributes()
    {
        super(DataBinningAttributes_numAdditionalAtts);

        numDimensions = NUMDIMENSIONS_ONE;
        dim1BinBasedOn = BINBASEDON_VARIABLE;
        dim1Var = new String("");
        dim1SpecifyRange = false;
        dim1MinRange = 0;
        dim1MaxRange = 1;
        dim1NumBins = 50;
        dim2BinBasedOn = BINBASEDON_VARIABLE;
        dim2Var = new String("");
        dim2SpecifyRange = false;
        dim2MinRange = 0;
        dim2MaxRange = 1;
        dim2NumBins = 50;
        dim3BinBasedOn = BINBASEDON_VARIABLE;
        dim3Var = new String("");
        dim3SpecifyRange = false;
        dim3MinRange = 0;
        dim3MaxRange = 1;
        dim3NumBins = 50;
        outOfBoundsBehavior = OUTOFBOUNDSBEHAVIOR_CLAMP;
        reductionOperator = REDUCTIONOPERATOR_AVERAGE;
        varForReduction = new String("");
        emptyVal = 0;
        outputType = OUTPUTTYPE_OUTPUTONBINS;
        removeEmptyValFromCurve = true;
    }

    public DataBinningAttributes(int nMoreFields)
    {
        super(DataBinningAttributes_numAdditionalAtts + nMoreFields);

        numDimensions = NUMDIMENSIONS_ONE;
        dim1BinBasedOn = BINBASEDON_VARIABLE;
        dim1Var = new String("");
        dim1SpecifyRange = false;
        dim1MinRange = 0;
        dim1MaxRange = 1;
        dim1NumBins = 50;
        dim2BinBasedOn = BINBASEDON_VARIABLE;
        dim2Var = new String("");
        dim2SpecifyRange = false;
        dim2MinRange = 0;
        dim2MaxRange = 1;
        dim2NumBins = 50;
        dim3BinBasedOn = BINBASEDON_VARIABLE;
        dim3Var = new String("");
        dim3SpecifyRange = false;
        dim3MinRange = 0;
        dim3MaxRange = 1;
        dim3NumBins = 50;
        outOfBoundsBehavior = OUTOFBOUNDSBEHAVIOR_CLAMP;
        reductionOperator = REDUCTIONOPERATOR_AVERAGE;
        varForReduction = new String("");
        emptyVal = 0;
        outputType = OUTPUTTYPE_OUTPUTONBINS;
        removeEmptyValFromCurve = true;
    }

    public DataBinningAttributes(DataBinningAttributes obj)
    {
        super(DataBinningAttributes_numAdditionalAtts);

        numDimensions = obj.numDimensions;
        dim1BinBasedOn = obj.dim1BinBasedOn;
        dim1Var = new String(obj.dim1Var);
        dim1SpecifyRange = obj.dim1SpecifyRange;
        dim1MinRange = obj.dim1MinRange;
        dim1MaxRange = obj.dim1MaxRange;
        dim1NumBins = obj.dim1NumBins;
        dim2BinBasedOn = obj.dim2BinBasedOn;
        dim2Var = new String(obj.dim2Var);
        dim2SpecifyRange = obj.dim2SpecifyRange;
        dim2MinRange = obj.dim2MinRange;
        dim2MaxRange = obj.dim2MaxRange;
        dim2NumBins = obj.dim2NumBins;
        dim3BinBasedOn = obj.dim3BinBasedOn;
        dim3Var = new String(obj.dim3Var);
        dim3SpecifyRange = obj.dim3SpecifyRange;
        dim3MinRange = obj.dim3MinRange;
        dim3MaxRange = obj.dim3MaxRange;
        dim3NumBins = obj.dim3NumBins;
        outOfBoundsBehavior = obj.outOfBoundsBehavior;
        reductionOperator = obj.reductionOperator;
        varForReduction = new String(obj.varForReduction);
        emptyVal = obj.emptyVal;
        outputType = obj.outputType;
        removeEmptyValFromCurve = obj.removeEmptyValFromCurve;

        SelectAll();
    }

    public int Offset()
    {
        return super.Offset() + super.GetNumAdditionalAttributes();
    }

    public int GetNumAdditionalAttributes()
    {
        return DataBinningAttributes_numAdditionalAtts;
    }

    public boolean equals(DataBinningAttributes obj)
    {
        // Create the return value
        return ((numDimensions == obj.numDimensions) &&
                (dim1BinBasedOn == obj.dim1BinBasedOn) &&
                (dim1Var.equals(obj.dim1Var)) &&
                (dim1SpecifyRange == obj.dim1SpecifyRange) &&
                (dim1MinRange == obj.dim1MinRange) &&
                (dim1MaxRange == obj.dim1MaxRange) &&
                (dim1NumBins == obj.dim1NumBins) &&
                (dim2BinBasedOn == obj.dim2BinBasedOn) &&
                (dim2Var.equals(obj.dim2Var)) &&
                (dim2SpecifyRange == obj.dim2SpecifyRange) &&
                (dim2MinRange == obj.dim2MinRange) &&
                (dim2MaxRange == obj.dim2MaxRange) &&
                (dim2NumBins == obj.dim2NumBins) &&
                (dim3BinBasedOn == obj.dim3BinBasedOn) &&
                (dim3Var.equals(obj.dim3Var)) &&
                (dim3SpecifyRange == obj.dim3SpecifyRange) &&
                (dim3MinRange == obj.dim3MinRange) &&
                (dim3MaxRange == obj.dim3MaxRange) &&
                (dim3NumBins == obj.dim3NumBins) &&
                (outOfBoundsBehavior == obj.outOfBoundsBehavior) &&
                (reductionOperator == obj.reductionOperator) &&
                (varForReduction.equals(obj.varForReduction)) &&
                (emptyVal == obj.emptyVal) &&
                (outputType == obj.outputType) &&
                (removeEmptyValFromCurve == obj.removeEmptyValFromCurve));
    }

    public String GetName() { return "DataBinning"; }
    public String GetVersion() { return "1.0"; }

    // Property setting methods
    public void SetNumDimensions(int numDimensions_)
    {
        numDimensions = numDimensions_;
        Select(0);
    }

    public void SetDim1BinBasedOn(int dim1BinBasedOn_)
    {
        dim1BinBasedOn = dim1BinBasedOn_;
        Select(1);
    }

    public void SetDim1Var(String dim1Var_)
    {
        dim1Var = dim1Var_;
        Select(2);
    }

    public void SetDim1SpecifyRange(boolean dim1SpecifyRange_)
    {
        dim1SpecifyRange = dim1SpecifyRange_;
        Select(3);
    }

    public void SetDim1MinRange(double dim1MinRange_)
    {
        dim1MinRange = dim1MinRange_;
        Select(4);
    }

    public void SetDim1MaxRange(double dim1MaxRange_)
    {
        dim1MaxRange = dim1MaxRange_;
        Select(5);
    }

    public void SetDim1NumBins(int dim1NumBins_)
    {
        dim1NumBins = dim1NumBins_;
        Select(6);
    }

    public void SetDim2BinBasedOn(int dim2BinBasedOn_)
    {
        dim2BinBasedOn = dim2BinBasedOn_;
        Select(7);
    }

    public void SetDim2Var(String dim2Var_)
    {
        dim2Var = dim2Var_;
        Select(8);
    }

    public void SetDim2SpecifyRange(boolean dim2SpecifyRange_)
    {
        dim2SpecifyRange = dim2SpecifyRange_;
        Select(9);
    }

    public void SetDim2MinRange(double dim2MinRange_)
    {
        dim2MinRange = dim2MinRange_;
        Select(10);
    }

    public void SetDim2MaxRange(double dim2MaxRange_)
    {
        dim2MaxRange = dim2MaxRange_;
        Select(11);
    }

    public void SetDim2NumBins(int dim2NumBins_)
    {
        dim2NumBins = dim2NumBins_;
        Select(12);
    }

    public void SetDim3BinBasedOn(int dim3BinBasedOn_)
    {
        dim3BinBasedOn = dim3BinBasedOn_;
        Select(13);
    }

    public void SetDim3Var(String dim3Var_)
    {
        dim3Var = dim3Var_;
        Select(14);
    }

    public void SetDim3SpecifyRange(boolean dim3SpecifyRange_)
    {
        dim3SpecifyRange = dim3SpecifyRange_;
        Select(15);
    }

    public void SetDim3MinRange(double dim3MinRange_)
    {
        dim3MinRange = dim3MinRange_;
        Select(16);
    }

    public void SetDim3MaxRange(double dim3MaxRange_)
    {
        dim3MaxRange = dim3MaxRange_;
        Select(17);
    }

    public void SetDim3NumBins(int dim3NumBins_)
    {
        dim3NumBins = dim3NumBins_;
        Select(18);
    }

    public void SetOutOfBoundsBehavior(int outOfBoundsBehavior_)
    {
        outOfBoundsBehavior = outOfBoundsBehavior_;
        Select(19);
    }

    public void SetReductionOperator(int reductionOperator_)
    {
        reductionOperator = reductionOperator_;
        Select(20);
    }

    public void SetVarForReduction(String varForReduction_)
    {
        varForReduction = varForReduction_;
        Select(21);
    }

    public void SetEmptyVal(double emptyVal_)
    {
        emptyVal = emptyVal_;
        Select(22);
    }

    public void SetOutputType(int outputType_)
    {
        outputType = outputType_;
        Select(23);
    }

    public void SetRemoveEmptyValFromCurve(boolean removeEmptyValFromCurve_)
    {
        removeEmptyValFromCurve = removeEmptyValFromCurve_;
        Select(24);
    }

    // Property getting methods
    public int     GetNumDimensions() { return numDimensions; }
    public int     GetDim1BinBasedOn() { return dim1BinBasedOn; }
    public String  GetDim1Var() { return dim1Var; }
    public boolean GetDim1SpecifyRange() { return dim1SpecifyRange; }
    public double  GetDim1MinRange() { return dim1MinRange; }
    public double  GetDim1MaxRange() { return dim1MaxRange; }
    public int     GetDim1NumBins() { return dim1NumBins; }
    public int     GetDim2BinBasedOn() { return dim2BinBasedOn; }
    public String  GetDim2Var() { return dim2Var; }
    public boolean GetDim2SpecifyRange() { return dim2SpecifyRange; }
    public double  GetDim2MinRange() { return dim2MinRange; }
    public double  GetDim2MaxRange() { return dim2MaxRange; }
    public int     GetDim2NumBins() { return dim2NumBins; }
    public int     GetDim3BinBasedOn() { return dim3BinBasedOn; }
    public String  GetDim3Var() { return dim3Var; }
    public boolean GetDim3SpecifyRange() { return dim3SpecifyRange; }
    public double  GetDim3MinRange() { return dim3MinRange; }
    public double  GetDim3MaxRange() { return dim3MaxRange; }
    public int     GetDim3NumBins() { return dim3NumBins; }
    public int     GetOutOfBoundsBehavior() { return outOfBoundsBehavior; }
    public int     GetReductionOperator() { return reductionOperator; }
    public String  GetVarForReduction() { return varForReduction; }
    public double  GetEmptyVal() { return emptyVal; }
    public int     GetOutputType() { return outputType; }
    public boolean GetRemoveEmptyValFromCurve() { return removeEmptyValFromCurve; }

    // Write and read methods.
    public void WriteAtts(CommunicationBuffer buf)
    {
        if(WriteSelect(0, buf))
            buf.WriteInt(numDimensions);
        if(WriteSelect(1, buf))
            buf.WriteInt(dim1BinBasedOn);
        if(WriteSelect(2, buf))
            buf.WriteString(dim1Var);
        if(WriteSelect(3, buf))
            buf.WriteBool(dim1SpecifyRange);
        if(WriteSelect(4, buf))
            buf.WriteDouble(dim1MinRange);
        if(WriteSelect(5, buf))
            buf.WriteDouble(dim1MaxRange);
        if(WriteSelect(6, buf))
            buf.WriteInt(dim1NumBins);
        if(WriteSelect(7, buf))
            buf.WriteInt(dim2BinBasedOn);
        if(WriteSelect(8, buf))
            buf.WriteString(dim2Var);
        if(WriteSelect(9, buf))
            buf.WriteBool(dim2SpecifyRange);
        if(WriteSelect(10, buf))
            buf.WriteDouble(dim2MinRange);
        if(WriteSelect(11, buf))
            buf.WriteDouble(dim2MaxRange);
        if(WriteSelect(12, buf))
            buf.WriteInt(dim2NumBins);
        if(WriteSelect(13, buf))
            buf.WriteInt(dim3BinBasedOn);
        if(WriteSelect(14, buf))
            buf.WriteString(dim3Var);
        if(WriteSelect(15, buf))
            buf.WriteBool(dim3SpecifyRange);
        if(WriteSelect(16, buf))
            buf.WriteDouble(dim3MinRange);
        if(WriteSelect(17, buf))
            buf.WriteDouble(dim3MaxRange);
        if(WriteSelect(18, buf))
            buf.WriteInt(dim3NumBins);
        if(WriteSelect(19, buf))
            buf.WriteInt(outOfBoundsBehavior);
        if(WriteSelect(20, buf))
            buf.WriteInt(reductionOperator);
        if(WriteSelect(21, buf))
            buf.WriteString(varForReduction);
        if(WriteSelect(22, buf))
            buf.WriteDouble(emptyVal);
        if(WriteSelect(23, buf))
            buf.WriteInt(outputType);
        if(WriteSelect(24, buf))
            buf.WriteBool(removeEmptyValFromCurve);
    }

    public void ReadAtts(int index, CommunicationBuffer buf)
    {
        switch(index)
        {
        case 0:
            SetNumDimensions(buf.ReadInt());
            break;
        case 1:
            SetDim1BinBasedOn(buf.ReadInt());
            break;
        case 2:
            SetDim1Var(buf.ReadString());
            break;
        case 3:
            SetDim1SpecifyRange(buf.ReadBool());
            break;
        case 4:
            SetDim1MinRange(buf.ReadDouble());
            break;
        case 5:
            SetDim1MaxRange(buf.ReadDouble());
            break;
        case 6:
            SetDim1NumBins(buf.ReadInt());
            break;
        case 7:
            SetDim2BinBasedOn(buf.ReadInt());
            break;
        case 8:
            SetDim2Var(buf.ReadString());
            break;
        case 9:
            SetDim2SpecifyRange(buf.ReadBool());
            break;
        case 10:
            SetDim2MinRange(buf.ReadDouble());
            break;
        case 11:
            SetDim2MaxRange(buf.ReadDouble());
            break;
        case 12:
            SetDim2NumBins(buf.ReadInt());
            break;
        case 13:
            SetDim3BinBasedOn(buf.ReadInt());
            break;
        case 14:
            SetDim3Var(buf.ReadString());
            break;
        case 15:
            SetDim3SpecifyRange(buf.ReadBool());
            break;
        case 16:
            SetDim3MinRange(buf.ReadDouble());
            break;
        case 17:
            SetDim3MaxRange(buf.ReadDouble());
            break;
        case 18:
            SetDim3NumBins(buf.ReadInt());
            break;
        case 19:
            SetOutOfBoundsBehavior(buf.ReadInt());
            break;
        case 20:
            SetReductionOperator(buf.ReadInt());
            break;
        case 21:
            SetVarForReduction(buf.ReadString());
            break;
        case 22:
            SetEmptyVal(buf.ReadDouble());
            break;
        case 23:
            SetOutputType(buf.ReadInt());
            break;
        case 24:
            SetRemoveEmptyValFromCurve(buf.ReadBool());
            break;
        }
    }

    public String toString(String indent)
    {
        String str = new String();
        str = str + indent + "numDimensions = ";
        if(numDimensions == NUMDIMENSIONS_ONE)
            str = str + "NUMDIMENSIONS_ONE";
        if(numDimensions == NUMDIMENSIONS_TWO)
            str = str + "NUMDIMENSIONS_TWO";
        if(numDimensions == NUMDIMENSIONS_THREE)
            str = str + "NUMDIMENSIONS_THREE";
        str = str + "\n";
        str = str + indent + "dim1BinBasedOn = ";
        if(dim1BinBasedOn == BINBASEDON_X)
            str = str + "BINBASEDON_X";
        if(dim1BinBasedOn == BINBASEDON_Y)
            str = str + "BINBASEDON_Y";
        if(dim1BinBasedOn == BINBASEDON_Z)
            str = str + "BINBASEDON_Z";
        if(dim1BinBasedOn == BINBASEDON_VARIABLE)
            str = str + "BINBASEDON_VARIABLE";
        str = str + "\n";
        str = str + stringToString("dim1Var", dim1Var, indent) + "\n";
        str = str + boolToString("dim1SpecifyRange", dim1SpecifyRange, indent) + "\n";
        str = str + doubleToString("dim1MinRange", dim1MinRange, indent) + "\n";
        str = str + doubleToString("dim1MaxRange", dim1MaxRange, indent) + "\n";
        str = str + intToString("dim1NumBins", dim1NumBins, indent) + "\n";
        str = str + indent + "dim2BinBasedOn = ";
        if(dim2BinBasedOn == BINBASEDON_X)
            str = str + "BINBASEDON_X";
        if(dim2BinBasedOn == BINBASEDON_Y)
            str = str + "BINBASEDON_Y";
        if(dim2BinBasedOn == BINBASEDON_Z)
            str = str + "BINBASEDON_Z";
        if(dim2BinBasedOn == BINBASEDON_VARIABLE)
            str = str + "BINBASEDON_VARIABLE";
        str = str + "\n";
        str = str + stringToString("dim2Var", dim2Var, indent) + "\n";
        str = str + boolToString("dim2SpecifyRange", dim2SpecifyRange, indent) + "\n";
        str = str + doubleToString("dim2MinRange", dim2MinRange, indent) + "\n";
        str = str + doubleToString("dim2MaxRange", dim2MaxRange, indent) + "\n";
        str = str + intToString("dim2NumBins", dim2NumBins, indent) + "\n";
        str = str + indent + "dim3BinBasedOn = ";
        if(dim3BinBasedOn == BINBASEDON_X)
            str = str + "BINBASEDON_X";
        if(dim3BinBasedOn == BINBASEDON_Y)
            str = str + "BINBASEDON_Y";
        if(dim3BinBasedOn == BINBASEDON_Z)
            str = str + "BINBASEDON_Z";
        if(dim3BinBasedOn == BINBASEDON_VARIABLE)
            str = str + "BINBASEDON_VARIABLE";
        str = str + "\n";
        str = str + stringToString("dim3Var", dim3Var, indent) + "\n";
        str = str + boolToString("dim3SpecifyRange", dim3SpecifyRange, indent) + "\n";
        str = str + doubleToString("dim3MinRange", dim3MinRange, indent) + "\n";
        str = str + doubleToString("dim3MaxRange", dim3MaxRange, indent) + "\n";
        str = str + intToString("dim3NumBins", dim3NumBins, indent) + "\n";
        str = str + indent + "outOfBoundsBehavior = ";
        if(outOfBoundsBehavior == OUTOFBOUNDSBEHAVIOR_CLAMP)
            str = str + "OUTOFBOUNDSBEHAVIOR_CLAMP";
        if(outOfBoundsBehavior == OUTOFBOUNDSBEHAVIOR_DISCARD)
            str = str + "OUTOFBOUNDSBEHAVIOR_DISCARD";
        str = str + "\n";
        str = str + indent + "reductionOperator = ";
        if(reductionOperator == REDUCTIONOPERATOR_AVERAGE)
            str = str + "REDUCTIONOPERATOR_AVERAGE";
        if(reductionOperator == REDUCTIONOPERATOR_MINIMUM)
            str = str + "REDUCTIONOPERATOR_MINIMUM";
        if(reductionOperator == REDUCTIONOPERATOR_MAXIMUM)
            str = str + "REDUCTIONOPERATOR_MAXIMUM";
        if(reductionOperator == REDUCTIONOPERATOR_STANDARDDEVIATION)
            str = str + "REDUCTIONOPERATOR_STANDARDDEVIATION";
        if(reductionOperator == REDUCTIONOPERATOR_VARIANCE)
            str = str + "REDUCTIONOPERATOR_VARIANCE";
        if(reductionOperator == REDUCTIONOPERATOR_SUM)
            str = str + "REDUCTIONOPERATOR_SUM";
        if(reductionOperator == REDUCTIONOPERATOR_COUNT)
            str = str + "REDUCTIONOPERATOR_COUNT";
        if(reductionOperator == REDUCTIONOPERATOR_RMS)
            str = str + "REDUCTIONOPERATOR_RMS";
        if(reductionOperator == REDUCTIONOPERATOR_PDF)
            str = str + "REDUCTIONOPERATOR_PDF";
        str = str + "\n";
        str = str + stringToString("varForReduction", varForReduction, indent) + "\n";
        str = str + doubleToString("emptyVal", emptyVal, indent) + "\n";
        str = str + indent + "outputType = ";
        if(outputType == OUTPUTTYPE_OUTPUTONBINS)
            str = str + "OUTPUTTYPE_OUTPUTONBINS";
        if(outputType == OUTPUTTYPE_OUTPUTONINPUTMESH)
            str = str + "OUTPUTTYPE_OUTPUTONINPUTMESH";
        str = str + "\n";
        str = str + boolToString("removeEmptyValFromCurve", removeEmptyValFromCurve, indent) + "\n";
        return str;
    }


    // Attributes
    private int     numDimensions;
    private int     dim1BinBasedOn;
    private String  dim1Var;
    private boolean dim1SpecifyRange;
    private double  dim1MinRange;
    private double  dim1MaxRange;
    private int     dim1NumBins;
    private int     dim2BinBasedOn;
    private String  dim2Var;
    private boolean dim2SpecifyRange;
    private double  dim2MinRange;
    private double  dim2MaxRange;
    private int     dim2NumBins;
    private int     dim3BinBasedOn;
    private String  dim3Var;
    private boolean dim3SpecifyRange;
    private double  dim3MinRange;
    private double  dim3MaxRange;
    private int     dim3NumBins;
    private int     outOfBoundsBehavior;
    private int     reductionOperator;
    private String  varForReduction;
    private double  emptyVal;
    private int     outputType;
    private boolean removeEmptyValFromCurve;
}

