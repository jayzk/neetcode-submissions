class Solution {
    public boolean isValid(String s) {
        Stack<Character> validate = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') { //push open brackets to stack
                validate.push(c);
            } else {
                char closed;
                if(validate.empty()) //if stack is empty, invalid parentheses
                    return false;
                else
                    closed = validate.pop();
                
                //check appropriate closing parenthesis
                if(c == '}' && closed != '{')
                    return false;
                else if(c == ']' && closed != '[')
                    return false;
                else if(c == ')' && closed != '(')
                    return false;
            }
        }

        //if stack is not empty, invalid parentheses
        if(!validate.empty())
            return false;
        else
            return true;
    }
}
