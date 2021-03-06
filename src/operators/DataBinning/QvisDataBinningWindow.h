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

#ifndef QVISBINWINDOW_H
#define QVISBINWINDOW_H

#include <QvisOperatorWindow.h>
#include <AttributeSubject.h>

class DataBinningAttributes;
class QLabel;
class QCheckBox;
class QComboBox;
class QLineEdit;
class QButtonGroup;
class QRadioButton;
class QvisVariableButton;

// ****************************************************************************
// Class: QvisDataBinningWindow
//
// Purpose:
//    Defines QvisDataBinningWindow class.
//
// Notes:      Autogenerated by xml2window.
//
// Programmer: xml2window
// Creation:   omitted
//
// Modifications:
//   
//   Hank Childs, Sun Jul 31 16:01:41 PDT 2011
//   Add support for binning based on spatial dimensions.
//
//   Hank Childs, Fri Jan  4 11:49:36 PST 2013
//   Remove unused bins for curves.
//
// ****************************************************************************

class QvisDataBinningWindow : public QvisOperatorWindow
{
    Q_OBJECT
  public:
    QvisDataBinningWindow(const int type,
                         DataBinningAttributes *subj,
                         const QString &caption = QString::null,
                         const QString &shortName = QString::null,
                         QvisNotepadArea *notepad = 0);
    virtual ~QvisDataBinningWindow();
    virtual void CreateWindowContents();
  protected:
    void UpdateWindow(bool doAll);
    virtual void GetCurrentValues(int which_widget);
  private slots:
    void numDimensionsChanged(int val);
    void dim1VarChanged(const QString &varName);
    void dim1SpecifyRangeToggled(bool);
    void dim1MinRangeProcessText();
    void dim1MaxRangeProcessText();
    void dim1NumBinsProcessText();
    void dim1BinBasedOnChanged(int);
    void dim2VarChanged(const QString &varName);
    void dim2SpecifyRangeToggled(bool);
    void dim2MinRangeProcessText();
    void dim2MaxRangeProcessText();
    void dim2NumBinsProcessText();
    void dim2BinBasedOnChanged(int);
    void dim3VarChanged(const QString &varName);
    void dim3SpecifyRangeToggled(bool);
    void dim3MinRangeProcessText();
    void dim3MaxRangeProcessText();
    void dim3NumBinsProcessText();
    void dim3BinBasedOnChanged(int);
    void outOfBoundsBehaviorChanged(int val);
    void outputChanged(int val);
    void reductionOperatorClicked(int val);
    void varForReductionChanged(const QString &varName);
    void emptyValProcessText();
    void removeEmptyBinsToggled(bool);
  private:
    QWidget      *numDimensions;
    QComboBox    *numDimensionsCombo;
    QvisVariableButton *dim1Var;
    QCheckBox *dim1SpecifyRange;
    QLineEdit *dim1MinRange;
    QLineEdit *dim1MaxRange;
    QLineEdit *dim1NumBins;
    QvisVariableButton *dim2Var;
    QCheckBox *dim2SpecifyRange;
    QLineEdit *dim2MinRange;
    QLineEdit *dim2MaxRange;
    QLineEdit *dim2NumBins;
    QvisVariableButton *dim3Var;
    QCheckBox *dim3SpecifyRange;
    QLineEdit *dim3MinRange;
    QLineEdit *dim3MaxRange;
    QLineEdit *dim3NumBins;
    QWidget      *outOfBoundsBehavior;
    QButtonGroup *outOfBoundsBehaviorButtonGroup;
    QWidget      *reductionOperator;
    QComboBox    *reductionCombo;
    QvisVariableButton *varForReduction;
    QLineEdit *emptyVal;
    QLabel *numDimensionsLabel;
    QLabel *dim1BinBasedOn;
    QRadioButton *dim1VarLabel;
    QRadioButton *dim1XLabel;
    QRadioButton *dim1YLabel;
    QRadioButton *dim1ZLabel;
    QButtonGroup *dim1BinBasedOnButtonGroup;
    QLabel *dim1MinRangeLabel;
    QLabel *dim1MaxRangeLabel;
    QLabel *dim1NumBinsLabel;
    QLabel *dim2BinBasedOn;
    QRadioButton *dim2VarLabel;
    QRadioButton *dim2XLabel;
    QRadioButton *dim2YLabel;
    QRadioButton *dim2ZLabel;
    QButtonGroup *dim2BinBasedOnButtonGroup;
    QLabel *dim2MinRangeLabel;
    QLabel *dim2MaxRangeLabel;
    QLabel *dim2NumBinsLabel;
    QLabel *dim3BinBasedOn;
    QRadioButton *dim3VarLabel;
    QRadioButton *dim3XLabel;
    QRadioButton *dim3YLabel;
    QRadioButton *dim3ZLabel;
    QButtonGroup *dim3BinBasedOnButtonGroup;
    QLabel *dim3MinRangeLabel;
    QLabel *dim3MaxRangeLabel;
    QLabel *dim3NumBinsLabel;
    QLabel *outOfBoundsBehaviorLabel;
    QLabel *reductionOperatorLabel;
    QLabel *varForReductionLabel;
    QLabel *emptyValLabel;
    QCheckBox *removeEmptyBins;
    QButtonGroup *outputButtonGroup;

    DataBinningAttributes *atts;
};



#endif
