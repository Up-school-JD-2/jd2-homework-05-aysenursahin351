class SystemNotWorkingException extends Exception {
  
	public SystemNotWorkingException(String message) {
         super(message);
    }
}
/*import java.time.LocalDate;

import java.time.LocalDate;

public class Payment {
    public static void main(String[] args) {
        try {
            makePayment("1234567890123456", "12/2023", "123", 100.00);
        } catch (InvalidAmountException | InvalidCardNumberException | InvalidExpirationDateException | InvalidSecurityCodeException e) {
            System.out.println("Ödeme işlemi başarısız: " + e.getMessage());
            try {
                makePayment("1234567890123456", "12/2023", "123", 100.00);
            } catch (SystemNotWorkingException ex) {
                System.out.println("Ödeme işlemi bir kez daha başarısız: " + ex.getMessage());
            }
        }
    

    public static void makePayment(String cardNumber, String expirationDate, String securityCode, double amount)
            throwsInvalidAmountException, InvalidCardNumberException, InvalidExpirationDateException, InvalidSecurityCodeException, SystemNotWorkingException {
        validateAmount(amount);
        validateCardNumber(cardNumber);
        validateExpirationDate(expirationDate);
        validateSecurityCode(securityCode);

        // Ödeme işlemlerinin gerçekleştirildiği bölüm
        double random = Math.random() * 100;
        if (random > 75) {
            throw new SystemNotWorkingException("Sistem şu anda çalışmıyor!");
        } else {
            // Ödeme işlemini gerçekleştirin
            System.out.println("Ödeme işlemi başarıyla tamamlandı!");
        }
    }

    public static void validateAmount(double amount) throws InvalidAmountException {
        if (amount <= 0 || amount % 1 != 0) {
            throw new InvalidAmountException("Geçersiz ödeme tutarı!");
        }
    }

    public static void validateCardNumber(String cardNumber) throws InvalidCardNumberException {
        if (cardNumber == null || cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            throw new InvalidCardNumberException("Geçersiz kart numarası!");
        }
    }

    public static void validateExpirationDate(String expirationDate) throws InvalidExpirationDateException {
        LocalDate currentDate = LocalDate.now();
        String[] parts = expirationDate.split("/");
        int month, year;

        try {
            month = Integer.parseInt(parts[0]);
            year = Integer.parseInt(parts[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidExpirationDateException("Geçersiz son kullanma tarihi!");
        }

        LocalDate expiration = LocalDate.of(2000 + year, month, 1);

        if (expiration.isBefore(currentDate.plusMonths(1))) {
            throw new InvalidExpirationDateException("Geçmiş bir son kullanma tarihi girdiniz!");
        }
    }

    public static void validateSecurityCode(String securityCode) throws InvalidSecurityCodeException {
        if (securityCode == null || securityCode.length() != 3 || !securityCode.matches("\\d+")) {
            throw new InvalidSecurityCodeException("Geçersiz güvenlik kodu!");
        }
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InvalidCardNumberException extends Exception {
    public InvalidCardNumberException(String message) {
        super(message);
    }
}

class InvalidExpirationDateException extends Exception {
    public InvalidExpirationDateException(String message) {
        super(message);
    }
}

class InvalidSecurityCodeException extends Exception {
    public InvalidSecurityCodeException(String message) {
        super(message);
    }
}

class SystemNotWorkingException extends Exception {
    public SystemNotWorkingException(String message){
        super(message);
    }
}

Bu kodu düzenleyerek, ödeme işlemi yapabilen bir uygulama yazabilirsiniz.

    public static void makePayment(String cardNumber, String expirationDate, String securityCode, double amount)
        throws InvalidAmountException, InvalidCardNumberException, InvalidExpirationDateException, InvalidSecurityCodeException, SystemNotWorkingException {
    validateAmount(amount);
    validateCardNumber(cardNumber);
    validateExpirationDate(expirationDate);
    validateSecurityCode(securityCode);

    // Ödeme işlemlerinin gerçekleştirildiği bölüm
    double random = Math.random() * 100;
    if (random > 75) {
        throw new SystemNotWorkingException("Sistem şu anda çalışmıyor!");
    } else {
        // Ödeme işlemini gerçekleştirin
        System.out.println("Ödeme işlemi başarıyla tamamlandı!");
    }
}

    public static void validateAmount(double amount) throws InvalidAmountException {
        if (amount < 0 || amount % 1 != 0) {
            throw new InvalidAmountException("Geçersiz ödeme tutarı!");
        }
    }

    public static void validateCardNumber(String cardNumber) throws InvalidCardNumberException {
        if (cardNumber == null || cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            throw new InvalidCardNumberException("Geçersiz kart numarası!");
        }
    }

    public static void validateExpirationDate(String expirationDate) throws InvalidExpirationDateException {
        LocalDate currentDate = LocalDate.now();
        String[] parts = expirationDate.split("/");
        int month, year;

        try {
            month = Integer.parseInt(parts[0]);
            year = Integer.parseInt(parts[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidExpirationDateException("Geçersiz son kullanma tarihi!");
        }

        LocalDate expiration = LocalDate.of(2000 + year, month, 1);

        if (expiration.isBefore(currentDate) || expiration.isEqual(currentDate)) {
            throw new InvalidExpirationDateException("Geçmiş bir son kullanma tarihi girdiniz!");
        }
    }

    public static void validateSecurityCode(String securityCode) throws InvalidSecurityCodeException {
        if (securityCode == null || securityCode.length() != 3 || !securityCode.matches("\\d+")) {
            throw new InvalidSecurityCodeException("Geçersiz güvenlik kodu!");
        }
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InvalidCardNumberException extends Exception {
    public InvalidCardNumberException(String message) {
        super(message);
    }
}

class InvalidExpirationDateException extends Exception {
    public InvalidExpirationDateException(String message) {
        super(message);
    }
}

class InvalidSecurityCodeException extends Exception {
    public InvalidSecurityCodeException(String message
*/