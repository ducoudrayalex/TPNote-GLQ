package test;

import java.util.Stack;
import commande.Controleur;
import outils.Demande;
import org.aspectj.lang.JoinPoint;

public aspect AspectJ {
    private int tabCount = 0;
    private Stack _StartTimeStack = new Stack();
 
    pointcut callAllumerBouton() : (call(* Controleur.allumerBouton(Demande))) && !within(AspectLogMethodExecution)
    && !within(Log);
    

 
    before() : callAllumerBouton()
    {
        PrintMethod(thisJoinPointStaticPart);
        tabCount++;
        _StartTimeStack.add(System.nanoTime());
    }
 
    pointcut callEteindreBouton() : (call(* Controleur.eteindreBouton(Demande)))
    && !within(AspectLogMethodExecution)
    && !within(Log);
    
    after() : callEteindreBouton()
    {
        Long methodExecutionTime = EvaluateExecutionTime();
        tabCount--;
        PrintMethod(thisJoinPointStaticPart, methodExecutionTime);
    }
 
    private Long EvaluateExecutionTime()
    {
        Long methodExecutionTime = System.nanoTime() - (Long)_StartTimeStack.pop();
        return methodExecutionTime;
    }
 
    private void PrintMethod(JoinPoint.StaticPart inPart)
    {
    	System.out.println(GetTabs() + inPart);
    }
 
    private void PrintMethod(JoinPoint.StaticPart inPart, long inExecutionTime)
    {
        System.out.println(GetTabs() + inPart + " Execution Time: "
                + inExecutionTime + " nanoseconds");
    }
 
    private String GetTabs()
    {
        String tabs = "";
        for (int i = 0; i < tabCount; i++)
        {
            tabs += "\t";
        }
        return tabs;
    }
}
