package pl.wszib.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.domain.Person;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SimpleController {


    private List<Person> listPerson;
    public SimpleController(){
        listPerson = generateList();
    }

    @GetMapping("basic")

    public String basic(Model model){
        String firstName = "Jan";
        String lastName = "Kowalski";
        model.addAttribute("fName", firstName);
        model.addAttribute("lName", lastName);


        Person person = new Person();
        person.setFirstName("Jacek");
        person.setLastName("Nowak");
        person.setPhoneNumber("78945613");
        person.setSalary(10);
        person.setVisible(true);

        model.addAttribute("person", person);



        return "basicTemplate";
    }


    @GetMapping("iteration")
    public String iteration(Model model){
        List<Person> list = generateList();
        model.addAttribute("list", listPerson);
        return "iterationTemplate";
    }


    @GetMapping ("forms")
    public String forms (Model model){
        model.addAttribute("person", new Person());

        return "formsTemplate";
    }


    @PostMapping("formsSave")
    public String formsSave(Person person, Model model){

        listPerson.add(person);
        return "successTemplate";
    }



    @GetMapping("links")
    public String links (Model model){
        return "linksTemplate";
    }


    @GetMapping("inter")
    public String inter (Model model){
        return "interTemplate";
    }







    private List<Person> generateList() {
        List<Person> list = new ArrayList<>();


        Person person1 = new Person();
        person1.setFirstName("Jacek");
        person1.setLastName("dupa");
        person1.setPhoneNumber("78945613");
        person1.setSalary(4010);
        person1.setVisible(true);
        list.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Jacek");
        person2.setLastName("Nowak");
        person2.setPhoneNumber("785645613");
        person2.setSalary(810);
        person2.setVisible(false);
        list.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Jacek");
        person3.setLastName("ćwik");
        person3.setPhoneNumber("945623413");
        person3.setSalary(170);
        person3.setVisible(true);
        list.add(person3);


        return list;
    }


    @GetMapping("fragments")
    public String fragments (Model model){
        return "fragments/fragmentsTemplates";
    }

    @GetMapping("fragments2")
    public String fragments2 (Model model){
        return "fragments/fragmentsTemplates2";
    }



}
