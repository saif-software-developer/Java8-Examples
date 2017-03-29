package chapter8.strategy;

public class Main {

	public static void main(String[] args) {

		ArabicHello arabicHello=new ArabicHello();
		EnglishHello englishHello = new EnglishHello();
		SpanishHello spanishHello=new SpanishHello();
		
		Translator translator;
		
		translator=new Translator(arabicHello);
		System.out.println(translator);
		
		translator=new Translator(englishHello);
		System.out.println(translator);
		
		translator=new Translator(spanishHello);
		System.out.println(translator);
		
		translator=new Translator(()->"Ciao");
		System.out.println(translator);
		
		translator=new Translator(()->"Bonjour");
		System.out.println(translator);
		
		
		
	}

}
