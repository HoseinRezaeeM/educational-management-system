package ir.education.system.management.validation;

import java.util.regex.Pattern;

public class RegexValidation {

        public static boolean validatonPassword(String password){
            Pattern pattern =Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
            return password.matches(pattern.pattern());
        }
        public static boolean validaitonEmail(String email){
            Pattern pattern =Pattern.compile("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}");
            return email.matches(pattern.pattern());
        }
        public static boolean validationMobileNumber(String mobileNumber){
            Pattern pattern =Pattern.compile("^[0-9]{11}$");
            return mobileNumber.matches(pattern.pattern());
        }
    }

