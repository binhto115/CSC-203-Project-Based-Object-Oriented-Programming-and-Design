    public class Calculator {
        public Calculator() {}

        public String additionOperator(String firstString, String secondString)  {
            // Create two empty linked lists
            LinkedList firstList = new LinkedList();
            LinkedList secondList = new LinkedList();
            LinkedList calculatedList = new LinkedList();
            int remainder2 = 0;

            // Reversing the lists for calculations
            firstList = firstList.reversedToList(firstString);
            secondList = secondList.reversedToList(secondString);


            // Traversing the linked lists
            Node currentNode1 = firstList.getFirstNode();
            Node currentNode2 = secondList.getFirstNode();

            LinkedList sizeCheck = new LinkedList();

            if (sizeCheck.size(firstString) == sizeCheck.size(secondString)) {
                while (currentNode1 != null) {
                int firstValue = Integer.parseInt(firstList.remove(0));
                int secondValue = Integer.parseInt(secondList.remove(0));
                int addValue = firstValue + secondValue + remainder2;

                if (addValue > 9) {
                    // This num is to be added to the calculated list
                    int remainder = addValue % 10;
                    //This step is used to carry over for the next calculation step
                    int getNum = addValue / 10;
                    remainder2 = getNum % 10;
                    calculatedList.addToFront(remainder);
                }
                else {
                    calculatedList.addToFront(addValue);
                    remainder2 = 0;
                }
                currentNode1 = currentNode1.getNode();
                currentNode2 = currentNode2.getNode();
                }
                if (remainder2 != 0 ) {
                calculatedList.addToFront(remainder2);
                }
            }
            else {
                while (currentNode1 != null || currentNode2 != null) {
                    if (currentNode1 == null) {
                        while (currentNode2 != null) {
                            int secondValue = Integer.parseInt(secondList.remove(0));
                            //System.out.println("first value: " + secondValue);
                            int addValue = secondValue + remainder2;
                            //System.out.println("addvalue: " + addValue);
                            if (addValue > 9) {
                                int remainder = addValue % 10;
                                //System.out.println("remainder: " + remainder);
                                int getNum = addValue / 10;
                                remainder2 = getNum % 10;
                                //System.out.println("remainder2: " + remainder2);

                                calculatedList.addToFront(remainder);
                            } else {
                                calculatedList.addToFront(addValue);
                                remainder2 = 0;
                            }
                            currentNode2 = currentNode2.getNode();
                        }
                    }
                    else if (currentNode2 == null) {
                        while (currentNode1 != null) {
                            int firstValue = Integer.parseInt(firstList.remove(0));
                            //System.out.println("first value: " + firstValue);
                            int addValue = firstValue + remainder2;
                            //System.out.println("addvalue: " + addValue);
                            if (addValue > 9) {
                                int remainder = addValue % 10;
                                //System.out.println("remainder: " + remainder);
                                int getNum = addValue / 10;
                                remainder2 = getNum % 10;
                                //System.out.println("remainder2: " + remainder2);

                                calculatedList.addToFront(remainder);
                            } else {
                                calculatedList.addToFront(addValue);
                                remainder2 = 0;
                            }
                            currentNode1 = currentNode1.getNode();
                        }
                    }
                    // When two numbers are equivalent in terms of digits
                    else {
                        int firstValue = Integer.parseInt(firstList.remove(0));
                        int secondValue = Integer.parseInt(secondList.remove(0));
                        int addValue = firstValue + secondValue + remainder2;

                        if (addValue > 9) {
                            // This num is to be added to the calculated list
                            int remainder = addValue % 10;
                            //This step is used to carry over for the next calculation step
                            int getNum = addValue / 10;
                            remainder2 = getNum % 10;
                            calculatedList.addToFront(remainder);

                        }
                        else {
                            calculatedList.addToFront(addValue);
                            remainder2 = 0;
                        }
                        currentNode1 = currentNode1.getNode();
                        currentNode2 = currentNode2.getNode();
                    }
                }
            }
            String result = "";
            Node currentNodeOfLst3 = calculatedList.getFirstNode();
            while (currentNodeOfLst3 != null) {
                result += Integer.toString(currentNodeOfLst3.getValue());
                currentNodeOfLst3 = currentNodeOfLst3.getNode();
            }
            return result;
        }


        public String multiplicationOperator(String firstString, String secondString) {
            LinkedList sizeCheck = new LinkedList();
            int remainder2 = 0;
            int counterZeroes = 0;
            int firstValue;
            // Perform actual calculations
            String storeSumPerDigit = "0";
            String product;

            // Switch two values of two variables
            if (sizeCheck.size(secondString) > sizeCheck.size(firstString)) {
                String temp = firstString;
                firstString = secondString;
                secondString = temp;
            }
            // Create two empty linked lists
            LinkedList secondList = new LinkedList();
            // Returning reversed lists for calculations
            secondList = secondList.reversedToList(secondString);
            // Traversing the linked lists
            Node currentNode2 = secondList.getFirstNode();

            while (currentNode2 != null) {
                int temp = Integer.parseInt(secondList.remove(0));

                // Instantiate inner lists so that they don't modify the original lists.
                LinkedList firstList = new LinkedList();
                firstList = firstList.reversedToList(firstString);
                Node currentNode1 = firstList.getFirstNode();
                LinkedList calculatedList = new LinkedList();
                // This is to iterate over the first list as you multiply by individual number one by one
                while (currentNode1 != null) {
                    firstValue = Integer.parseInt(firstList.remove(0));
                    int multiply = temp * firstValue + remainder2;
                    if (multiply > 9) {
                        int remainder = multiply % 10;
                        int getNum = multiply / 10;
                        remainder2 = getNum % 10;
                        calculatedList.addToFront(remainder);
                    } else {
                        calculatedList.addToFront(multiply);
                        remainder2 = 0;
                    }
                    currentNode1 = currentNode1.getNode();
                }
                if (remainder2 != 0) {
                    calculatedList.addToFront(remainder2);
                    remainder2 = 0;
                }

                // Convert the digits into strings
                String result = "";
                String addZeroesToFront = "";
                String reversedAddZeroesToFront;
                Node currentNode3 = calculatedList.getFirstNode();
                while (currentNode3 != null) {
                    result += Integer.toString(currentNode3.getValue());
                    currentNode3 = currentNode3.getNode();
                }

                //System.out.println("result: " + result);
                // Reverse the number back to its og state
                if (counterZeroes == 0) {
                    product = calculatedList.reversedToString(result);
                } else {
                    product = calculatedList.reversedToString(storeSumPerDigit);
                }

                // Reverse back for addition
                product = calculatedList.reversedToString(product);
                //System.out.println("product: " + product);
                // Adding zeroes based on counterZeroes
                String zero = "";
                if (counterZeroes > 0) {
                    for (int i = 0; i < counterZeroes; i++) {
                        zero += "0";
                    }
                    reversedAddZeroesToFront = calculatedList.reversedToString(result);
                    addZeroesToFront = zero + reversedAddZeroesToFront;
                    addZeroesToFront = calculatedList.reversedToString(addZeroesToFront);
                }
                //System.out.println("added zeroes: " + addZeroesToFront);

                storeSumPerDigit = additionOperator(product, addZeroesToFront);
                //System.out.println(storeSumPerDigit);
                // Increment counter by 1 and move on to the next node
                counterZeroes += 1;
                currentNode2 = currentNode2.getNode();}
            return storeSumPerDigit;
        }

        public String exponentiationOperator(String firstString, String secondString) {
            /*String productPerDigit = firstString;
            for (int i = 1; i < Integer.parseInt(secondString); i++){
                String temp = productPerDigit;
                productPerDigit = multiplicationOperator(firstString, temp);
            }
            return productPerDigit;*/

            //Instantiate a linked list
            int secondStringInt = Integer.parseInt(secondString);
            String calNum;
            String temp1st = "1";
            String result = null;

            if (secondStringInt == 0) {
                return "1";
            }
            while (secondStringInt != 1) {
                if (secondStringInt % 2 == 0) {
                    secondStringInt = secondStringInt / 2;
                    //System.out.println("even side n: " + secondStringInt);
                    calNum = multiplicationOperator(firstString, firstString);
                    //System.out.println("even side x: " + calNum);
                    firstString = calNum;
                }
                else if (secondStringInt % 2 == 1){
                    secondStringInt = (secondStringInt - 1) /2;
                    //System.out.println("odd side n: " + secondStringInt);
                    calNum = multiplicationOperator(firstString, firstString);
                    //System.out.println("odd side x: " + calNum);
                    temp1st = multiplicationOperator(temp1st, firstString);
                    //System.out.println("temp: " + temp1st);
                    firstString = calNum;
                }
            }
            result = multiplicationOperator(firstString, temp1st);
            return result;
        }
    }
