package credit7ua;

import java.util.Random;

public class fakeNumberCards {
    // Массив с фиктивными номерами карт
    private static final String[] fakeNumber = {
            "4556876924054151",
            "4532933646635020",
            "4412494176402627",
            "5167773538213935",
            "5450237872997053",
            "5541944092564966",
            "4844707127404541",
            "4175007787526579",
            "4844071544977336",
            "4556457802834442281",
            "371238243194484",
            "372926843504990",
            "343599846493234",
            "6011250934021606",
            "6011936783847782",
           "6011713768029158178",
      //      JCB
           "3539939241759755",
           "3544309946846088",
            "3543527815358232685",
    //        Diners Club - North America
            "5401091402023694",
            "5560638107064097",
     //       Diners Club - Carte Blanche
            "30230464640546",
            "30078853742054",
            "30267976119825",
//            Diners Club - International
            "36515048765171",
            "36351979323438",
            "36951468101896",
//            Maestro
            "6761796340281731",
            "0604739855614262",
            "6304096002395554",
            "6377852558846917",
            "6387017733940906",
            "6375968410322095"

    };

    public static void main(String[] args) {
        String randomCard = generateNumber();
        System.out.println(randomCard);
    }

    // Метод для генерации случайного номера карты из массива
    public static String generateNumber() {
        return fakeNumber[new Random().nextInt(fakeNumber.length)];
    }
}



