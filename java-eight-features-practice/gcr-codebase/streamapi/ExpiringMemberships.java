package streamapi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.*;

public class ExpiringMemberships {

    static class Member {
        private String name;
        private LocalDate expiryDate;

        public Member(String name, LocalDate expiryDate) {
            this.name = name;
            this.expiryDate = expiryDate;
        }

        public String getName() {
            return name;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Expiry Date: " + expiryDate;
        }
    }

    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
                new Member("Rahul", LocalDate.now().plusDays(10)),
                new Member("Aman", LocalDate.now().plusDays(40)),
                new Member("Sneha", LocalDate.now().plusDays(25)),
                new Member("Priya", LocalDate.now().plusDays(5)),
                new Member("Karan", LocalDate.now().plusDays(60))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<Member> expiringSoon = members.stream()
                .filter(member -> 
                        !member.getExpiryDate().isBefore(today) &&
                        !member.getExpiryDate().isAfter(next30Days))
                .collect(Collectors.toList());

        System.out.println("Members whose membership expires within next 30 days:\n");

        expiringSoon.forEach(System.out::println);
    }
}

