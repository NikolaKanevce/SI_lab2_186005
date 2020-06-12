import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    User user = new User("Nikola", "blablabla", "nikolakanevce@hotmail.com");
    SILab2 testObject = new SILab2();
    List<String> allUsers = new ArrayList<String>();

    @Test
    void functionMultipleCondition() {
        System.out.println("Multiple condition criterion");

        //TEST SLUCAI ZA PRVIOT PREDIKATEN JAZEL SO POVEKE USLOVI
        //if (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername()))
        assertFalse(testObject.function(new User(null, user.password, user.email), allUsers));
        //test slucaj koga user.username == null, soodvetniot if uslov(2) vrakja false, isto kako i celata funkcija
        assertFalse(testObject.function(new User(user.username, user.password, null), allUsers));
        //test slucaj koga user.email == null, soodvetniot if uslov(2) vrakja false, isto kako i celata funkcija
        allUsers.add("Nikola"); //vo lista allUsers, dodavame username koj e ist na user.username
        assertFalse(testObject.function(user, allUsers));
        //test slucaj koga !user.contains(user.username) == false, soodvetniot if uslov(2) vrakja false, isto kako i celata funkcija
        allUsers = new ArrayList<>();//se prazni listata
        assertTrue(testObject.function(new User(user.username, user.password, user.email), allUsers));
        //test slucaj koga site iskazi se tocni, funkcijata vrakja True


        //TEST SLUCAI ZA VTORIOT PREDIKATEN JAZEL SO POVEKE USLOVI
        //if (atChar && user.getEmail().charAt(i)=='.')
        assertTrue(testObject.function(new User(user.username, user.password, user.email), allUsers));
        //test slucaj koga i prviot i vtoriot iskaz se tocni
        assertFalse(testObject.function(new User(user.username, user.password, "nikolakanevce@hotmailcom"), allUsers));
        //test slucaj koga prviot iskaz e tocen, a vtoriot iskaz e gresen
        assertFalse(testObject.function(new User(user.username, user.password, "nikolakanevce.hotmail.com"), allUsers));
        ////test slucaj koga prviot iskaz e gresen, a vtoriot ne se proveruva


        //TEST SLUCAI ZA TRETIOT PREDIKATEN JAZEL SO POVEKE USLOVI
        //if (atChar && dotChar)
        assertTrue(testObject.function(new User(user.username, user.password, user.email), allUsers));
        //test slucaj koga i prviot i vtoriot iskaz se tocni
        assertFalse(testObject.function(new User(user.username, user.password, "nikolakanevce@hotmailcom"), allUsers));
        //test slucaj koga prviot iskaz e tocen, a vtoriot iskaz e gresen
        assertFalse(testObject.function(new User(user.username, user.password, "nikolakanevce.hotmail.com"), allUsers));
        ////test slucaj koga prviot iskaz e gresen, a vtoriot ne se proveruva


    }

    @Test
    void everyPathCriterion(){

        System.out.println("Every path criterion");

        assertFalse(testObject.function(null, allUsers));
        //test slucaj koj ja opfakja patekata 1-11

        allUsers.add(user.username);
        assertFalse(testObject.function(user, allUsers));
        //test slucaj koj ja opfakja patekata 1-2-11
        allUsers = new ArrayList<>();

        assertFalse(testObject.function(new User("Nikola", "blabla", ""),allUsers));
        //test slucaj koj ja opfakja patekata 1-2-3-4.1-4.2-9-11
        assertFalse(testObject.function(new User("Nikola", "blabla", "nikola"),allUsers));
        //test slucaj koj ja opfakja patekata 1-2-3-4.1-4.2-5-7-9-11
        assertFalse(testObject.function(new User("Nikola", "blabla", "nikola@"),allUsers));
        //test slucaj koj ja opfakja patekata 1-2-3-4.1-4.2-5-6-7-9-11
        assertTrue(testObject.function(user, allUsers));
        //test slucaj koj prvo ja opfakja patekata 1-2-3-4.1-4.2-5-6-7, pa potoa vo nekoja naredna iteracija 4.2-5-6-7,
        // i na kraj odi 4.2-9-10 i cela funkcija vrakja true
    }
}
