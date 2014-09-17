package fr.afcepf.atod21.cov.test;

import java.io.IOException;

import org.xml.sax.SAXException;

import fr.afcepf.atod21.cov.factory.Factory;

public class test {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SAXException, IOException {
		Factory fact = Factory.getInstance();
		fact.getAction("/affichage");
		fact.getActionForm("paffichage");
	}
}
