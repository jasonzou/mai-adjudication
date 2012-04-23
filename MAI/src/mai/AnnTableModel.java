
/*
 * MAI - Multi-document Adjudication Interface
 * 
 * Copyright Amber Stubbs (astubbs@cs.brandeis.edu)
 * Department of Computer Science, Brandeis University
 * 
 * MAI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package mai;

import javax.swing.table.DefaultTableModel;

/**
  * 
  * AnnTableModel creates a TableModel that 
  * allows the ID column to be uneditable.  This
  * helps prevent user-created database conflicts by 
  * ensuring the IDs being generated will not be changed,
  * and makes it so that users can double-click on the 
  * ID in order to see where that tag appears in the text.
  *
  * @author Amber Stubbs 
  */

class AnnTableModel extends DefaultTableModel{

private static final long serialVersionUID = -3921141969882892250L; //generated by Eclipse

private String goldStandardName;

/**
 * Returns true or false depending on whether
 * the cell is editable or not.  Currently the 
 * only cells that are editable are cells for 
 * tags in the Gold Standard that don't 
 * contain the file name (keeping the first 
 * column uneditable enables it to be double-clicked
 * so extents can be highlighted).
 */
public boolean isCellEditable(int row, int col){
    String val = (String)getValueAt(row,0);
    if (col == 0){
        return false;
    }

    if (val.equals(goldStandardName)){
        return true;
    }
    else if (col == getColumnCount()-1){
        return true;
    }
    else return false;
}

public void setGoldStandardName(String gs){
    goldStandardName = gs;
}

public String getGoldStandardName(){
    return goldStandardName;
}


}
