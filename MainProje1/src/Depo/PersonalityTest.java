package Depo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersonalityTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int extraversion = 0, introversion = 0;
        int sensing = 0, intuition = 0;
        int thinking = 0, feeling = 0;
        int judging = 0, perceiving = 0;

        System.out.println("\u001B[36mMBTI Testine Hoş Geldiniz! Bu testin amacı size kendinizi daha iyi tanıyabilme fırsatı sunmaktır bunun için lütfen soruları DOĞRU bir şekilde cevaplayın.\nBaşlamadan önce isminizi girin : \u001B[0m");
        String isim = scanner.nextLine();

       
        extraversion += askYesNoQuestion(scanner, "Sosyal etkinliklerde enerji kazanır mısınız?");
        introversion += askYesNoQuestion(scanner, "Düşüncelerinizi başkalarıyla paylaşmayı sever misiniz?");
        introversion += askYesNoQuestion(scanner, "Yalnız vakit geçirmek sizi daha mı çok rahatlatır?");
        extraversion += askYesNoQuestion(scanner, "Yeni insanlarla tanışmaktan hoşlanır mısınız?");

      
        sensing += askYesNoQuestion(scanner, "Detaylara odaklanmayı mı tercih edersiniz?");
        intuition += askYesNoQuestion(scanner, "Sezgilerinize güvenerek mi karar verirsiniz?");
        sensing += askYesNoQuestion(scanner, "Pratik çözümler bulmak sizin için önemli mi?");
        intuition += askYesNoQuestion(scanner, "Geleceğe dair hayaller kurmayı mı seversiniz?");

       
        thinking += askYesNoQuestion(scanner, "Kararlarınızda mantık ön planda mı olur?");
        feeling += askYesNoQuestion(scanner, "İnsanlara yardım etmeyi mi daha çok istersiniz?");
        thinking += askYesNoQuestion(scanner, "Tartışmalarda mantıksal yaklaşımı tercih eder misiniz?");
        feeling += askYesNoQuestion(scanner, "Diğer insanların hislerine önem verir misiniz?");

       
        judging += askYesNoQuestion(scanner, "Planlı çalışmak sizin için önemli midir?");
        perceiving += askYesNoQuestion(scanner, "Çoğunlukla esnek bir yapıda mısınız?");
        judging += askYesNoQuestion(scanner, "Görevlerinizi vaktinden önce tamamlar mısınız?");
        perceiving += askYesNoQuestion(scanner, "Son dakikada işleri yapmayı tercih eder misiniz?");

        thinking += askYesNoQuestion(scanner, "Günlük Tutmaktan keyif alır mısınız ?");
        feeling += askYesNoQuestion(scanner, "İnsanların duygusal durumlarını kolayca anlayabilir misiniz?");
        judging += askYesNoQuestion(scanner, "Genellikle önceden belirlenmiş bir düzende çalışmayı tercih eder misiniz?");
        perceiving += askYesNoQuestion(scanner, "Yenilikçi fikirler geliştirmeyi  sever misiniz?");

        // MBTI Tipini Belirleme
        String personalityType = "";
        personalityType += (extraversion > introversion) ? "E" : "I";
        personalityType += (sensing > intuition) ? "S" : "N";
        personalityType += (thinking > feeling) ? "T" : "F";
        personalityType += (judging > perceiving) ? "J" : "P";

        // Grafiksel Çıktı
        int totalEI = extraversion + introversion;
        int totalSN = sensing + intuition;
        int totalTF = thinking + feeling;
        int totalJP = judging + perceiving;

        System.out.println("\n--- Kişilik Özellikleri ---");
        
        printBar("Extraversion", (double) extraversion / totalEI * 100);
        printBar("Introversion", (double) introversion / totalEI * 100);
        printBar("Sensing", (double) sensing / totalSN * 100);
        printBar("Intuition", (double) intuition / totalSN * 100);
        printBar("Thinking", (double) thinking / totalTF * 100);
        printBar("Feeling", (double) feeling / totalTF * 100);
        printBar("Judging", (double) judging / totalJP * 100);
        printBar("Perceiving", (double) perceiving / totalJP * 100);

        // Kişilik tipi açıklaması
        String explanation = "";

        switch (personalityType) {
            case "INTJ":
                explanation = "Açıklama: Stratejik düşünme becerisine sahip olan INTJ'ler bağımsız, kararlı ve hedeflerine ulaşmak için sistematik yollar izler. Karmaşık problemleri çözme ve geleceği planlama konusunda güçlüdürler.\n"
                        + "Olumsuz Özellikler: Aşırı eleştirel olabilirler, başkalarıyla iletişimde zorluk yaşayabilirler ve duygusal bağ kurmakta zorlanabilirler.";
                break;
           
            case "INTP":
                explanation = "Açıklama: Meraklı, mantıklı ve analiz yeteneği yüksek olan INTP'ler yeni fikirlere açık ve yaratıcıdır. Genelde teoriler üzerine yoğunlaşır ve sorunları derinlemesine analiz etmeyi severler.\n"
                        + "Olumsuz Özellikler: Sosyal etkileşimde zorluklar yaşayabilirler, aşırı analiz yaparak karar vermekte gecikebilirler ve duygusal yönlerden kopuk olabilirler.";
                break;
            
            case "ENTJ":
                System.out.println("Açıklama: Doğuştan lider ruhlu olan ENTJ'ler, organizasyon yetenekleri ve stratejik düşünme becerileri ile dikkat çeker. Hedef odaklıdır ve çevresindeki insanları etkileyerek büyük işler başarmaya çalışırlar.");
                System.out.println("Olumsuz Özellikler: Otoriter olabilirler, başkalarını kontrol etme eğiliminde olabilirler ve empati konusunda zayıf olabilirler.");
                break;
                
            case "ENTP":
                System.out.println("Açıklama: Yenilikçi ve enerjik ENTP'ler, fikir üretmeyi ve tartışmayı sever. Geleneksel düşünce kalıplarını sorgulayan ENTP'ler, her zaman yeni çözüm yolları arar.");
                System.out.println("Olumsuz Özellikler: Duygusal bağ kurmada zorlanabilirler, aşırı enerjik olmaları bazen sıkıcı olabilir ve projeleri yarım bırakma eğiliminde olabilirler.");
                break;
                
            case "INFJ":
                System.out.println("Açıklama: Derin bir içsel değer sistemi olan INFJ'ler, başkalarına yardım etme isteğiyle doludur. Sezgisel ve empatik yapılarıyla, insanları anlamada güçlüdürler.");
                System.out.println("Olumsuz Özellikler: Aşırı idealist olabilirler, kendilerini fazla duygusal olarak tükenmiş hissedebilirler ve sınırlar koymada zorluk çekebilirler.");
                break;
                
            case "INFP":
                System.out.println("Açıklama: İdealist ve yaratıcı INFP'ler, genellikle kendi değerlerine göre yaşarlar. Duygusal ve hayalperest yapıları, onları sanatsal ve anlam dolu şeylere yönlendirir.");
                System.out.println("Olumsuz Özellikler: Aşırı duygusal olabilirler, pratiklikten uzak olabilirler ve bazen çok hayalci oldukları için gerçeklikten kopabilirler.");
                break;
                
            case "ENFJ":
                System.out.println("Açıklama: İyi birer lider ve destekleyici olan ENFJ'ler, sosyal ortamlarda doğal bir çekim gücüne sahiptir. Diğer insanlara ilham verme ve onları yönlendirme yetenekleriyle tanınır.");
                System.out.println("Olumsuz Özellikler: Başkalarına yardım etmek için kendilerini ihmal edebilirler, çok fazla sorumluluk alabilirler ve aşırı duygusal olabilirler.");
                break;
                
            case "ENFP":
                System.out.println("Açıklama: İyimser, enerjik ve ilham verici ENFP'ler, yenilikçi fikirler üretmeyi ve insanlarla güçlü bağlar kurmayı sever. Esnek ve maceracıdır.");
                System.out.println("Olumsuz Özellikler: Sabırsız olabilirler, projeleri yarım bırakma eğiliminde olabilirler ve bazen çok dağınık olabilirler.");
                break;
                
            case "ISTJ":
                System.out.println("Açıklama: Disiplinli ve güvenilir ISTJ'ler, sorumluluk sahibidir ve kurallara önem verir. Geleneksel değerlere bağlılıklarıyla bilinir ve görevlerini ciddiyetle yerine getirir.");
                System.out.println("Olumsuz Özellikler: Aşırı katı olabilirler, yenilikçi düşünceye kapalı olabilirler ve bazen çok muhafazakar olabilirler.");
                break;
                
            case "ISFJ":           	
                System.out.println("Açıklama: ISFJ'ler, başkalarına yardım etmeyi ve güvenilir olmaktan gurur duyarlar. Detaylara dikkat ederler ve başkalarına hizmet etmeyi severler.");
                System.out.println("Olumsuz Özellikler: Kendilerini başkalarına çok fazla adadıkları için tükenmiş hissedebilirler, yeniliklere kapalı olabilirler ve aşırı duygusal olabilirler.");
                break;
                
            case "ESTJ":
                System.out.println("Açıklama: Pratik, sorumluluk sahibi ve organizasyon yetenekleri güçlü ESTJ'ler, genellikle liderlik pozisyonlarında yer alır. Düzenli ve sistemli bir yaklaşım benimserler.");
                System.out.println("Olumsuz Özellikler: Otoriter olabilirler, duygusal ihtiyaçlara duyarsız olabilirler ve değişime karşı dirençli olabilirler.");
                break;
                
            case "ESFJ":
                System.out.println("Açıklama: Sosyal ve yardımsever ESFJ'ler, başkalarına destek olmayı ve toplum içinde uyum yaratmayı sever. Duygusal zekaları yüksektir ve başkalarının ihtiyaçlarına duyarlıdır.");
                System.out.println("Olumsuz Özellikler: Aşırı derecede başkalarına bağımlı olabilirler, kendi ihtiyaçlarını göz ardı edebilirler ve zaman zaman aşırı duygusal olabilirler.");
                break;
                
            case "ISTP":
                System.out.println("Açıklama: Pratik ve problem çözme yeteneği yüksek ISTP'ler, kendilerine güvenen ve bağımsız kişilerdir. Macera arayışındadırlar ve genellikle el becerisi gerektiren işler yapmayı severler.");
                System.out.println("Olumsuz Özellikler: Duygusal bağlar kurmakta zorlanabilirler, risk almaktan çekinmeyebilirler ve bazen fazla içe dönük olabilirler.");
                break;
                
            case "ISFP":
                System.out.println("Açıklama: Sanatçı ruhlu ve duyarlı ISFP'ler, doğayı ve güzellikleri takdir ederler. Huzurlu ve sessiz bir hayat tercih ederler ve estetik değerlere büyük önem verirler.");
                System.out.println("Olumsuz Özellikler: Karar almakta zorlanabilirler, fazla çekingen olabilirler ve bazen çok duygusal olabilirler.");
                break;
                
            case "ESTP":
                System.out.println("Açıklama: Enerjik, maceracı ve pratik ESTP'ler, genellikle risk almayı ve anı yaşamayı severler. Hızlı düşünme yetenekleriyle, ani kararlar alabilirler.");
                System.out.println("Olumsuz Özellikler: Duygusal anlamda yüzeysel olabilirler, uzun vadeli planlardan kaçınabilirler ve zaman zaman aşırı cesur olabilirler.");
                break;
                
            case "ESFP":
                System.out.println("Açıklama: Eğlenceli, canlı ve sosyal ESFP'ler, çevresindeki insanlarla vakit geçirmekten hoşlanır. Anı yaşamayı ve diğer insanları mutlu etmeyi önemser.");
                System.out.println("Olumsuz Özellikler: Aşırı sosyal olabilirler, sorumluluklardan kaçınabilirler ve bazen düşünmeden hareket edebilirler.");
                break;
                                              
            default:
                explanation = "Bu MBTI türü için henüz açıklama bulunmamaktadır.";
                break;
        }

        System.out.println("\nTest Sonucu: Kişilik Tipiniz " + personalityType);
        System.out.println(explanation);

        
        try (FileWriter writer = new FileWriter("PersonalityTestResults.txt", true)) {
            writer.write("Test Sonucu: Adınız : " + isim + " Kişilik Tipiniz " + personalityType + "\n");
            writer.write(explanation + "\n\n");
            System.out.println("\nSonuçlar başarıyla dosyaya kaydedildi.");
        } catch (IOException e) {
            System.out.println("Dosyaya yazılırken bir hata oluştu: " + e.getMessage());
        }

        scanner.close();
    }

    
    private static int askYesNoQuestion(Scanner scanner, String question) {
        String answer;
        while (true) {
            System.out.println(question + " (Evet/Hayır)");
            answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("Evet")) {
                return 1;
            } else if (answer.equalsIgnoreCase("Hayır")) {
                return 0;
            } else {
                System.out.println("\u001B[31mLütfen geçerli bir cevap girin: 'Evet' veya 'Hayır'.\u001B[0m");
            }
        }
    }

   
    private static void printBar(String label, double percent) {
        int length = (int) percent / 10; // Yüzdeyi 10'a bölerek kare sayısını belirleriz.
        System.out.print(label + ": ");
        for (int i = 0; i < length; i++) {
            System.out.print("█"); // Her yüzde 10 için bir kare basılır.
        }
        System.out.println(" " + String.format("%.2f", percent) + "%"); // Bar sonunda yüzdelik değeri gösterilir.
    }
}
