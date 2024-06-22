package com.example.fxml_manual;

public class extra {

    public static void main(String[] args) throws NoClassDefFoundError{
        try{
            extra.main(args);
        }
        catch (StackOverflowError e){
            System.out.println("StackOverFlowError Caught " + e);
        }
        catch (NoClassDefFoundError e){
            System.out.println("NoClassDefFoundError Caught" + e);
        }
        catch (Exception e){
            System.out.println("Exception Caught" + e);
        }
    }
}
