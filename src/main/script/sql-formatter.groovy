/**
 * 標準入力からSQL文を読み取り、整形したSQL文を標準出力に出力します。
 */

@Grab(group='org.hibernate', module='hibernate-core', version='5.2.3.Final')
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;

def formatter = new BasicFormatterImpl()

String original = System.in.text
String formatted = formatter.format(original)
println formatted