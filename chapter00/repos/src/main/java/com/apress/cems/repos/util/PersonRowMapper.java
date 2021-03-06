/*
Freeware License, some rights reserved

Copyright (c) 2019 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.apress.cems.repos.util;

import com.apress.cems.dao.Person;
import org.springframework.jdbc.core.RowMapper;
import static com.apress.cems.util.DateProcessor.toDate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        var id = rs.getLong("ID");
        var username = rs.getString("USERNAME");
        var firstname = rs.getString("FIRSTNAME");
        var lastname = rs.getString("LASTNAME");
        var password = rs.getString("PASSWORD");
        var hiringDate = rs.getTimestamp("HIRINGDATE").toLocalDateTime();

        var person = new Person();
        person.setId(id);
        person.setUsername(username);
        person.setFirstName(firstname);
        person.setLastName(lastname);
        person.setPassword(password);
        person.setHiringDate(hiringDate);
        return person;
    }
}
