/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package a2_2101140073;

import java.util.Vector;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.TextIO;
import static utils.TextIO.getln;
import static utils.TextIO.putln;
import static utils.TextIO.writeFile;
import static utils.TextIO.writeStandardOutput;

import static utils.TextIO.*;

/**
 * @overview PCProg is a program that captures data about PC objects
 *    and displays a report about them on the console.
 * 
 * @attributes
 *  objs  Set<PC>
 *  
 * @object
 *  A typical PCProg is {c1,...,cn} where c1,...,cn are pcs
 * 
 * @abstract_properties
 *  mutable(objs)=true /\ optional(objs)=false
 *
 */
public class PCProg {
  @DomainConstraint(mutable=true,optional=false)
  private Set<PC> objs;
  
  /**
   * @effects
   *  initialise this to have an empty set of PCs
   */
  public PCProg() {
    objs = new Set<>();
  }
  
  /**
   * @effects
   *  if objs is not empty
   *    display to the standard console a text-based tabular report on objs
   *    return this report
   *  else
   *    display nothing and return null
   */
  public String displayReport() {
    if (objs.size() > 0) {
      Vector<PC> pcs = objs.getElements();
      
      PCReport reportObj = new PCReport();
      return reportObj.displayReport(pcs.toArray(new PC[pcs.size()]));
    } else {
      return null;
    }
  }
  
  /**
   * @effects 
   *  save report to a file pcs.txt in the same directory 
   *  as the program's
   */
  public void saveReport(String report) {
    String fileName = "pcs.txt";
    writeFile(fileName);
    putln(report);
    writeStandardOutput();
  }

  /**
   * The run method
   * @effects
   *  initialise an instance of PCProg 
   *  create objects from data entered by the user
   *  display a report on the objects 
   *  prompt user to save report to file
   *  if user answers "Y"
   *    save report 
   *  else
   *    end 
   */
  public static void main(String[] args) {
    //
    PCProg prog = new PCProg();
    
    // create objects
    try {
      prog.createObjects();
    
      // display report
      String report = prog.displayReport();
        
      if (report != null) {
        // prompt user to save report
        putln("Save report to file? [Y/N]");
        String toSave = getln();
        if (toSave.equals("Y")) {
          prog.saveReport(report);
          putln("report saved");
        }
      }
    } catch (NotPossibleException e) {
      System.err.printf("%s: %s%n", e, e.getMessage());
    }
    
    putln("~END~");
  }
  public Set<PC> getObjects() {
    return objs;
  }
    private void createObjects() {
        String cont = "Y";
        while ("Y".equals(cont)) {
        System.err.printf("Enter model: ");
        String model = TextIO.getlnString();
        System.err.printf("Enter year: ");
        int year = TextIO.getlnInt();
        System.err.printf("Enter manufacturer: ");
        String manufacturer = TextIO.getlnString();
        PC pc = PCFactory.createPC(model, year, manufacturer);
        while (true){
        System.err.printf("Enter component: ");
        String com = TextIO.getlnString();
        if("".equals(com))
            break;
        pc.addComponent(com);
        }
        objs.insert(pc);
        System.err.printf("(s)he wishes to continue? [Y/N]\n");
        cont = TextIO.getlnString();
        }
    }
}
