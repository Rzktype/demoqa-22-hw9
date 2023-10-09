package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en-GB"));
    final String[] genders = new String[]{"Male", "Female", "Other"},
            subject = new String[]{"Maths", "Arts", "Biology"},
            hobby = new String[]{"Sports", "Reading", "Music"},
            pictures = new String[]{"1.bmp", "2.bmp", "3.bmp"};

    final Map<String, String[]> stateAndCity = new HashMap<>();

    {
        stateAndCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateAndCity.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        stateAndCity.put("Haryana", new String[]{"Karnal", "Panipat"});
        stateAndCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            phone = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1901, 2020)),
            subjects = getRandomSubject(),
            hobbies = getRandomHobbies(),
            picture = getRandomPicture(),
            address = faker.address().fullAddress(),
            chooseState = getRandomStates(),
            chooseCity = getRandomStateCities(chooseState);

    public String getRandomGender() {
        return faker.options().option(genders);

    }

    public String getRandomSubject() {
        return faker.options().option(subject);

    }

    public String getRandomHobbies() {
        return faker.options().option(hobby);

    }

    public String getRandomPicture() {
        return faker.options().option(pictures);

    }

    public String getRandomStates() {

        return faker.options().option(stateAndCity.keySet().toArray()).toString();

    }

    public String getRandomStateCities(String state) {
        return faker.options().option(stateAndCity.get(state));
    }

}

