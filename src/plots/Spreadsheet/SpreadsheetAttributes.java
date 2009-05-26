// ***************************************************************************
//
// Copyright (c) 2000 - 2008, Lawrence Livermore National Security, LLC
// Produced at the Lawrence Livermore National Laboratory
// LLNL-CODE-400142
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

package llnl.visit.plots;

import llnl.visit.AttributeSubject;
import llnl.visit.CommunicationBuffer;
import llnl.visit.Plugin;
import llnl.visit.ColorAttribute;
import java.lang.Double;
import java.util.Vector;

// ****************************************************************************
// Class: SpreadsheetAttributes
//
// Purpose:
//    Contains the attributes for the visual spreadsheet.
//
// Notes:      Autogenerated by xml2java.
//
// Programmer: xml2java
// Creation:   omitted
//
// Modifications:
//   
// ****************************************************************************

public class SpreadsheetAttributes extends AttributeSubject implements Plugin
{
    // Enum values
    public final static int NORMALAXIS_X = 0;
    public final static int NORMALAXIS_Y = 1;
    public final static int NORMALAXIS_Z = 2;


    public SpreadsheetAttributes()
    {
        super(17);

        subsetName = new String("Whole");
        formatString = new String("%1.6f");
        useColorTable = false;
        colorTableName = new String("Default");
        showTracerPlane = true;
        tracerColor = new ColorAttribute(255, 0, 0, 150);
        normal = NORMALAXIS_Z;
        sliceIndex = 0;
        spreadsheetFont = new String("Courier,12,-1,5,50,0,0,0,0,0");
        showPatchOutline = true;
        showCurrentCellOutline = false;
        currentPick = 0;
        currentPickType = 0;
        currentPickValid = false;
        currentPickLetter = new String("");
        pastPicks = new Vector();
        pastPickLetters = new Vector();
    }

    public SpreadsheetAttributes(SpreadsheetAttributes obj)
    {
        super(17);

        int i;

        subsetName = new String(obj.subsetName);
        formatString = new String(obj.formatString);
        useColorTable = obj.useColorTable;
        colorTableName = new String(obj.colorTableName);
        showTracerPlane = obj.showTracerPlane;
        tracerColor = new ColorAttribute(obj.tracerColor);
        normal = obj.normal;
        sliceIndex = obj.sliceIndex;
        spreadsheetFont = new String(obj.spreadsheetFont);
        showPatchOutline = obj.showPatchOutline;
        showCurrentCellOutline = obj.showCurrentCellOutline;
        currentPick = obj.currentPick;
        currentPickType = obj.currentPickType;
        currentPickValid = obj.currentPickValid;
        currentPickLetter = new String(obj.currentPickLetter);
        pastPicks = new Vector(obj.pastPicks.size());
        for(i = 0; i < obj.pastPicks.size(); ++i)
        {
            Double dv = (Double)obj.pastPicks.elementAt(i);
            pastPicks.addElement(new Double(dv.doubleValue()));
        }

        pastPickLetters = new Vector(obj.pastPickLetters.size());
        for(i = 0; i < obj.pastPickLetters.size(); ++i)
            pastPickLetters.addElement(new String((String)obj.pastPickLetters.elementAt(i)));


        SelectAll();
    }

    public boolean equals(SpreadsheetAttributes obj)
    {
        int i;

        // Compare the elements in the pastPicks vector.
        boolean pastPicks_equal = (obj.pastPicks.size() == pastPicks.size());
        for(i = 0; (i < pastPicks.size()) && pastPicks_equal; ++i)
        {
            // Make references to Double from Object.
            Double pastPicks1 = (Double)pastPicks.elementAt(i);
            Double pastPicks2 = (Double)obj.pastPicks.elementAt(i);
            pastPicks_equal = pastPicks1.equals(pastPicks2);
        }
        // Compare the elements in the pastPickLetters vector.
        boolean pastPickLetters_equal = (obj.pastPickLetters.size() == pastPickLetters.size());
        for(i = 0; (i < pastPickLetters.size()) && pastPickLetters_equal; ++i)
        {
            // Make references to String from Object.
            String pastPickLetters1 = (String)pastPickLetters.elementAt(i);
            String pastPickLetters2 = (String)obj.pastPickLetters.elementAt(i);
            pastPickLetters_equal = pastPickLetters1.equals(pastPickLetters2);
        }
        // Create the return value
        return ((subsetName.equals(obj.subsetName)) &&
                (formatString.equals(obj.formatString)) &&
                (useColorTable == obj.useColorTable) &&
                (colorTableName.equals(obj.colorTableName)) &&
                (showTracerPlane == obj.showTracerPlane) &&
                (tracerColor == obj.tracerColor) &&
                (normal == obj.normal) &&
                (sliceIndex == obj.sliceIndex) &&
                (spreadsheetFont.equals(obj.spreadsheetFont)) &&
                (showPatchOutline == obj.showPatchOutline) &&
                (showCurrentCellOutline == obj.showCurrentCellOutline) &&
                (currentPick == obj.currentPick) &&
                (currentPickType == obj.currentPickType) &&
                (currentPickValid == obj.currentPickValid) &&
                (currentPickLetter.equals(obj.currentPickLetter)) &&
                pastPicks_equal &&
                pastPickLetters_equal);
    }

    public String GetName() { return "Spreadsheet"; }
    public String GetVersion() { return "1.0"; }

    // Property setting methods
    public void SetSubsetName(String subsetName_)
    {
        subsetName = subsetName_;
        Select(0);
    }

    public void SetFormatString(String formatString_)
    {
        formatString = formatString_;
        Select(1);
    }

    public void SetUseColorTable(boolean useColorTable_)
    {
        useColorTable = useColorTable_;
        Select(2);
    }

    public void SetColorTableName(String colorTableName_)
    {
        colorTableName = colorTableName_;
        Select(3);
    }

    public void SetShowTracerPlane(boolean showTracerPlane_)
    {
        showTracerPlane = showTracerPlane_;
        Select(4);
    }

    public void SetTracerColor(ColorAttribute tracerColor_)
    {
        tracerColor = tracerColor_;
        Select(5);
    }

    public void SetNormal(int normal_)
    {
        normal = normal_;
        Select(6);
    }

    public void SetSliceIndex(int sliceIndex_)
    {
        sliceIndex = sliceIndex_;
        Select(7);
    }

    public void SetSpreadsheetFont(String spreadsheetFont_)
    {
        spreadsheetFont = spreadsheetFont_;
        Select(8);
    }

    public void SetShowPatchOutline(boolean showPatchOutline_)
    {
        showPatchOutline = showPatchOutline_;
        Select(9);
    }

    public void SetShowCurrentCellOutline(boolean showCurrentCellOutline_)
    {
        showCurrentCellOutline = showCurrentCellOutline_;
        Select(10);
    }

    public void SetCurrentPick(int currentPick_)
    {
        currentPick = currentPick_;
        Select(11);
    }

    public void SetCurrentPickType(int currentPickType_)
    {
        currentPickType = currentPickType_;
        Select(12);
    }

    public void SetCurrentPickValid(boolean currentPickValid_)
    {
        currentPickValid = currentPickValid_;
        Select(13);
    }

    public void SetCurrentPickLetter(String currentPickLetter_)
    {
        currentPickLetter = currentPickLetter_;
        Select(14);
    }

    public void SetPastPicks(Vector pastPicks_)
    {
        pastPicks = pastPicks_;
        Select(15);
    }

    public void SetPastPickLetters(Vector pastPickLetters_)
    {
        pastPickLetters = pastPickLetters_;
        Select(16);
    }

    // Property getting methods
    public String         GetSubsetName() { return subsetName; }
    public String         GetFormatString() { return formatString; }
    public boolean        GetUseColorTable() { return useColorTable; }
    public String         GetColorTableName() { return colorTableName; }
    public boolean        GetShowTracerPlane() { return showTracerPlane; }
    public ColorAttribute GetTracerColor() { return tracerColor; }
    public int            GetNormal() { return normal; }
    public int            GetSliceIndex() { return sliceIndex; }
    public String         GetSpreadsheetFont() { return spreadsheetFont; }
    public boolean        GetShowPatchOutline() { return showPatchOutline; }
    public boolean        GetShowCurrentCellOutline() { return showCurrentCellOutline; }
    public int            GetCurrentPick() { return currentPick; }
    public int            GetCurrentPickType() { return currentPickType; }
    public boolean        GetCurrentPickValid() { return currentPickValid; }
    public String         GetCurrentPickLetter() { return currentPickLetter; }
    public Vector         GetPastPicks() { return pastPicks; }
    public Vector         GetPastPickLetters() { return pastPickLetters; }

    // Write and read methods.
    public void WriteAtts(CommunicationBuffer buf)
    {
        if(WriteSelect(0, buf))
            buf.WriteString(subsetName);
        if(WriteSelect(1, buf))
            buf.WriteString(formatString);
        if(WriteSelect(2, buf))
            buf.WriteBool(useColorTable);
        if(WriteSelect(3, buf))
            buf.WriteString(colorTableName);
        if(WriteSelect(4, buf))
            buf.WriteBool(showTracerPlane);
        if(WriteSelect(5, buf))
            tracerColor.Write(buf);
        if(WriteSelect(6, buf))
            buf.WriteInt(normal);
        if(WriteSelect(7, buf))
            buf.WriteInt(sliceIndex);
        if(WriteSelect(8, buf))
            buf.WriteString(spreadsheetFont);
        if(WriteSelect(9, buf))
            buf.WriteBool(showPatchOutline);
        if(WriteSelect(10, buf))
            buf.WriteBool(showCurrentCellOutline);
        if(WriteSelect(11, buf))
            buf.WriteInt(currentPick);
        if(WriteSelect(12, buf))
            buf.WriteInt(currentPickType);
        if(WriteSelect(13, buf))
            buf.WriteBool(currentPickValid);
        if(WriteSelect(14, buf))
            buf.WriteString(currentPickLetter);
        if(WriteSelect(15, buf))
            buf.WriteDoubleVector(pastPicks);
        if(WriteSelect(16, buf))
            buf.WriteStringVector(pastPickLetters);
    }

    public void ReadAtts(int n, CommunicationBuffer buf)
    {
        for(int i = 0; i < n; ++i)
        {
            int index = (int)buf.ReadByte();
            switch(index)
            {
            case 0:
                SetSubsetName(buf.ReadString());
                break;
            case 1:
                SetFormatString(buf.ReadString());
                break;
            case 2:
                SetUseColorTable(buf.ReadBool());
                break;
            case 3:
                SetColorTableName(buf.ReadString());
                break;
            case 4:
                SetShowTracerPlane(buf.ReadBool());
                break;
            case 5:
                tracerColor.Read(buf);
                Select(5);
                break;
            case 6:
                SetNormal(buf.ReadInt());
                break;
            case 7:
                SetSliceIndex(buf.ReadInt());
                break;
            case 8:
                SetSpreadsheetFont(buf.ReadString());
                break;
            case 9:
                SetShowPatchOutline(buf.ReadBool());
                break;
            case 10:
                SetShowCurrentCellOutline(buf.ReadBool());
                break;
            case 11:
                SetCurrentPick(buf.ReadInt());
                break;
            case 12:
                SetCurrentPickType(buf.ReadInt());
                break;
            case 13:
                SetCurrentPickValid(buf.ReadBool());
                break;
            case 14:
                SetCurrentPickLetter(buf.ReadString());
                break;
            case 15:
                SetPastPicks(buf.ReadDoubleVector());
                break;
            case 16:
                SetPastPickLetters(buf.ReadStringVector());
                break;
            }
        }
    }

    public String toString(String indent)
    {
        String str = new String();
        str = str + stringToString("subsetName", subsetName, indent) + "\n";
        str = str + stringToString("formatString", formatString, indent) + "\n";
        str = str + boolToString("useColorTable", useColorTable, indent) + "\n";
        str = str + stringToString("colorTableName", colorTableName, indent) + "\n";
        str = str + boolToString("showTracerPlane", showTracerPlane, indent) + "\n";
        str = str + indent + "tracerColor = {" + tracerColor.Red() + ", " + tracerColor.Green() + ", " + tracerColor.Blue() + ", " + tracerColor.Alpha() + "}\n";
        str = str + indent + "normal = ";
        if(normal == NORMALAXIS_X)
            str = str + "NORMALAXIS_X";
        if(normal == NORMALAXIS_Y)
            str = str + "NORMALAXIS_Y";
        if(normal == NORMALAXIS_Z)
            str = str + "NORMALAXIS_Z";
        str = str + "\n";
        str = str + intToString("sliceIndex", sliceIndex, indent) + "\n";
        str = str + stringToString("spreadsheetFont", spreadsheetFont, indent) + "\n";
        str = str + boolToString("showPatchOutline", showPatchOutline, indent) + "\n";
        str = str + boolToString("showCurrentCellOutline", showCurrentCellOutline, indent) + "\n";
        str = str + intToString("currentPick", currentPick, indent) + "\n";
        str = str + intToString("currentPickType", currentPickType, indent) + "\n";
        str = str + boolToString("currentPickValid", currentPickValid, indent) + "\n";
        str = str + stringToString("currentPickLetter", currentPickLetter, indent) + "\n";
        str = str + doubleVectorToString("pastPicks", pastPicks, indent) + "\n";
        str = str + stringVectorToString("pastPickLetters", pastPickLetters, indent) + "\n";
        return str;
    }


    // Attributes
    private String         subsetName;
    private String         formatString;
    private boolean        useColorTable;
    private String         colorTableName;
    private boolean        showTracerPlane;
    private ColorAttribute tracerColor;
    private int            normal;
    private int            sliceIndex;
    private String         spreadsheetFont;
    private boolean        showPatchOutline;
    private boolean        showCurrentCellOutline;
    private int            currentPick;
    private int            currentPickType;
    private boolean        currentPickValid;
    private String         currentPickLetter;
    private Vector         pastPicks; // vector of Double objects
    private Vector         pastPickLetters; // vector of String objects
}

