package test;

public class DemandeTestExecution {

	public static void main(String[] args) throws Exception {
		DemandeTest test = new DemandeTest();
		
		test.setUp();
		test.tearDown();
		test.testChangeSens();
		test.testDemande1();
		test.testDemandeIntSens1();
		test.testEnDescente();
		test.testEnMontee();
		test.testEqualsObject();
		test.testEstIndefini();
		test.testEtage();
		test.testPasseEtageSuivant1();
		test.testPasseEtageSuivant2();
		test.testSens();
	}

}
