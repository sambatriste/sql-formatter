package com.github.sambatriste;

import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.Formatter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class SqlFormatter {

    private final Reader reader;

    private final Writer writer;

    public static void main(String[] args) throws IOException {
        SqlFormatter sqlFormatter = new SqlFormatter(System.in, System.out);
        sqlFormatter.format();
    }

    public SqlFormatter(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public SqlFormatter(InputStream in, OutputStream out) {
        this(new InputStreamReader(in), new OutputStreamWriter(out));
    }

    public void format() throws IOException {
        String original = readSql();
        String formatted = newFormatter().format(original);
        writer.write(formatted);
        writer.flush();
    }

    private String readSql() throws IOException {
        int c;
        StringBuilder sql = new StringBuilder(1024);
        while ((c = reader.read()) != -1) {
            sql.append((char) c);
        }
        return sql.toString();

    }

    private Formatter newFormatter() {
        return new CustomFormatter();
    }
}
