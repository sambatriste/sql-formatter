package com.github.sambatriste;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SqlFormatterTest {

    @Test
    public void test() throws IOException {
        String original = "SELECT * FROM HOGE WHERE HOGE.FUGA = :fuga";
        String expected =
        "SELECT\n" +
        "  * \n" +
        "FROM\n" +
        "  HOGE \n" +
        "WHERE\n" +
        "  HOGE.FUGA = :fuga";
        String formatted = format(original);
        assertThat(formatted, is(expected));

    }

    private String format(String sql) throws IOException {
        StringReader reader = new StringReader(sql);
        StringWriter writer = new StringWriter();
        SqlFormatter sut = new SqlFormatter(reader, writer);
        sut.format();
        return writer.toString();

    }

}