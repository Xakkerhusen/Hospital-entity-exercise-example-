package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Hospital hospital = new Hospital();
        hospital.setName("name1");
        hospital.setAddress("address1");
        hospital.setSectionName("section1");
        hospital.setPhone("+1");
        session.save(hospital);

        Profile profile = new Profile();
        profile.setName("ali");
        profile.setSurname("aliyev");
        profile.setAddress("Padress1");
        profile.setPhone("+1");
        profile.setDriverCertificate(UUID.randomUUID());
        session.save(profile);

        Transport transport = new Transport();
        transport.setModel("vaz");
        transport.setHospital(hospital);
        session.save(transport);

        WorkShift workShift = new WorkShift();
        workShift.setStartTime(LocalTime.now());
        workShift.setDurationHour(6);
        workShift.setProfile(profile);
        session.save(workShift);

        EMS ems = new EMS();
        ems.setDayOfService(LocalDate.now());
        ems.setLevelOfUrgency(LevelOfUrgency.YELLOW);
        ems.setHospital(hospital);
        ems.setProfile(profile);
        ems.setTransport(transport);
        session.save(ems);

        transaction.commit();

        Query query = session.createQuery("from EMS where id=1");
        List resultList = query.getResultList();
        EMS result = (EMS) resultList.get(0);
        System.out.println(result);

        System.out.println("Hello world!");
    }
}