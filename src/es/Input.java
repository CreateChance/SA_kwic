// -*- Java -*-
/*
 * <copyright>
 * 
 *  Copyright (c) 2002
 *  Institute for Information Processing and Computer Supported New Media (IICM),
 *  Graz University of Technology, Austria.
 * 
 * </copyright>
 * 
 * <file>
 * 
 *  Name:    Input.java
 * 
 *  Purpose: Input reads and parses the KWIC input file
 * 
 *  Created: 05 Nov 2002 
 * 
 *  $Id$
 * 
 *  Description:
 *    Input reads and parses the KWIC input file
 * </file>
*/

package kwic.es;

/*
 * $Log$
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  An object of the Input class is responsible for reading and parsing the content of 
 *  a KWIC input file. The format of the KWIC input file is as follows:
 *  <ul>
 *  <li>Lines are separated by the line separator character(s) (on Unix '\n', on Windows '\r\n')
 *  <li>Each line consists of a number of words. Words are delimited by any number and combination
 *  of the space chracter (' ') and the horizontal tabulation chracter ('\t').
 *  </ul>
 *  The entered data is parsed and stored in memory as an instance of the LineStorageWrapper class. The data
 *  is parsed in the following way:
 *  <ul>
 *  <li>All line separators are removed from the data; for each new line in the file a new line
 *  is added to the LineStorageWrapper instance
 *  <li>All horizontal tabulation word delimiters are removed
 *  <li>All space character word delimiters are removed
 *  <li>From characters between any two word delimiters a new string is created; the new string
 *  is added to the LineStorageWrapper instance.
 *  </ul>
 *  @author  dhelic
 *  @version $Id$
*/

public class Input{

//----------------------------------------------------------------------
/**
 * Fields
 *
 */
	private Scanner scanner = new Scanner(System.in);
//----------------------------------------------------------------------

//----------------------------------------------------------------------
/**
 * Constructors
 *
 */
//----------------------------------------------------------------------

//----------------------------------------------------------------------
/**
 * Methods
 *
 */
//----------------------------------------------------------------------

//----------------------------------------------------------------------
/**
 * This method reads and parses a KWIC input file. If an I/O exception occurs
 * during the execution of this method, an error message is shown and program
 * exits.
 * @param file name of KWIC input file
 * @param line_storage holds the parsed data
 * @return void
 */

  public String readLine(){
	  return scanner.nextLine();
  }

//----------------------------------------------------------------------
/**
 * Inner classes
 *
 */
//----------------------------------------------------------------------

}
