package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        int num = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
                num++;
            }
        }
        rsl = rsl / num;
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double rsl = 0;
            int num = 0;
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
                num++;
            }
            rsl = rsl / num;
            averageList.add(new Label(pupil.name(), rsl));
        }
        return averageList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> listOfSubjects = new LinkedHashMap<>();
        for (Subject subject : pupils.get(0).subjects()) {
            listOfSubjects.put(subject.name(), 0);
        }
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                listOfSubjects.put(subject.name(), listOfSubjects.get(subject.name()) + subject.score());
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : listOfSubjects.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        int currentScore = 0;
        int maxScore = 0;
        String name = "";
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                currentScore += subject.score();
            }
            if (currentScore > maxScore) {
                maxScore = currentScore;
                name = pupil.name();
            }
            currentScore = 0;
        }
        return new Label(name, maxScore);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        int maxScore = 0;
        String name = "";
        Map<String, Integer> listOfSubjects = new LinkedHashMap<>();
        for (Subject subject : pupils.get(0).subjects()) {
            listOfSubjects.put(subject.name(), 0);
        }
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                listOfSubjects.put(subject.name(), listOfSubjects.get(subject.name()) + subject.score());
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : listOfSubjects.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                name = entry.getKey();
            }
        }
        return new Label(name, maxScore);
    }
}
