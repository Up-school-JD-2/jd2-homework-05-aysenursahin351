import java.time.LocalDate;
/// Format:makePayment("1234567890123456", "122023", "123", 100.00);
import java.util.Scanner;

public class Payment {
    public static void main(String[] args) throws SystemNotWorkingException, InvalidAmountException, InvalidCardNumberException, InvalidExpirationDateException, InvalidSecurityCodeException {
    	 System.out.println("Ödeme Sayfasına Yönlendirildiniz ");
 	    System.out.println("Gerekli Alanları Doldurunuz.");
 	    Scanner scan = new Scanner(System.in);
 	    System.out.println("Ödeme Tutarını giriniz:Örnek: 100.00");
 	   double amount = scan.nextDouble();
 	  scan.nextLine();
 	    System.out.println("Kart Numarasını giriniz:Örnek:1234567890123456");
 	    String cardNo = scan.nextLine();
 	    System.out.println("Son Kullanma Tarihini giriniz (AA/YY)");
 	    String expirationDate = scan.nextLine();

 	    System.out.println("Güvenlik Kodunu giriniz:Örnek:123");
 	    String cvv = scan.nextLine();
    	try {
            makePayment(cardNo, expirationDate, cvv, amount);
        } catch (InvalidAmountException | InvalidCardNumberException | InvalidExpirationDateException | InvalidSecurityCodeException e) {
            System.out.println("Ödeme işlemi başarısız: " + e.getMessage());
            try {
            	   System.out.println("Ödeme Tutarını giriniz:Örnek: 100.00");
            	   double amount1 = scan.nextDouble();
            	 	  scan.nextLine();
            	    System.out.println("Kart Numarasını giriniz:Örnek:1234567890123456");
            	    String cardNo1 = scan.nextLine();

            	    System.out.println("Son Kullanma Tarihini giriniz (AA/YY)");
            	    String expirationDate1 = scan.nextLine();

            	    System.out.println("Güvenlik Kodunu giriniz:Örnek:123");
            	    String cvv1 = scan.nextLine();
                makePayment(cardNo1, expirationDate1, cvv1, amount1);
            } catch (SystemNotWorkingException ex) {
                System.out.println("Ödeme işlemi bir kez daha başarısız: " + ex.getMessage());
            }
        }
    }

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






