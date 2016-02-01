/**
 * @author Mustafa Youldash <mmyouldash@uqu.edu.sa>.
 * @copyright (c) 2016 Umm Al-Qura University. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * * Neither the name of the author nor the names of its contributors may be used
 * to endorse or promote products derived from this software without specific
 * prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * Standing Order System package created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */
package standingordersystem;

import java.util.Collection;
import java.util.ArrayList;

/**
 * Address class.
 */
public class Address implements SimpleKey {

	private String id;
	private String line1;
	private String line2;
	private String contactPerson;
	private String contactPhone;
	
	/**
	 * Default constructor.
	 * 
	 * @param id
	 * @param line1
	 * @param line2
	 * @param contactPerson
	 * @param contactPhone
	 */
	public Address(String id, String line1, String line2, String contactPerson, String contactPhone) {
		
		/*
		 * Assuming that all parameters are not null. No error handling is made for simplicity. 
		 */
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.contactPerson = contactPerson;
		this.contactPhone = contactPhone;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		
		return id;
	}
	
	public String getKey() {
		
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		
		this.id = id;
	}

	/**
	 * @return the line1
	 */
	public String getLine1() {
		
		return line1;
	}

	/**
	 * @param line1 the line1 to set
	 */
	public void setLine1(String line1) {
		
		this.line1 = line1;
	}

	/**
	 * @return the line2
	 */
	public String getLine2() {
		
		return line2;
	}

	/**
	 * @param line2 the line2 to set
	 */
	public void setLine2(String line2) {
		
		this.line2 = line2;
	}

	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		
		return contactPerson;
	}

	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		
		this.contactPerson = contactPerson;
	}

	/**
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		
		return contactPhone;
	}

	/**
	 * @param contactPhone the contactPhone to set
	 */
	public void setContactPhone(String contactPhone) {
		
		this.contactPhone = contactPhone;
	}
	
	/**
	 * @return a string description
	 */
	public String toString() {
		
		return "Address[id: " + getId() +
			", line1: " + getLine1() +
			", line2: " + getLine2() +
			", contactPerson: " + getContactPerson() +
			", contactPhone: " + getContactPhone() + "]";
	}
}
