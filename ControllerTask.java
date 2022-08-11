package com.example.tasktracker.controller;

import com.example.tasktracker.model.Api;
import com.example.tasktracker.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControllerTask {

    ArrayList<Task> tasks=new ArrayList<>();
    @GetMapping("/task")
    public ArrayList<Task> getTasks(){
        return tasks;
    }
    @PostMapping("/task")
    public Api addTask(@RequestBody Task task){
        tasks.add(task);
        return new Api("task added :)");
    }

    @DeleteMapping("/task")
    public Api deleteTask(@RequestParam int id){
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId()==id ){
                tasks.remove(i);}}
   return new Api("the task deleted :)"); }

    @PutMapping("/task")
    public  Api updateTask(@RequestParam int id, @RequestParam Task task){
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId()==id ){
                tasks.set(i,task);}}
   return new Api("your task updated "); }

    @PutMapping("/task/status")
    public  Api changeStatus (@RequestParam int id, @RequestParam String status){
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId()==id ){
                Task task=tasks.get(i);
                task.setStatus(status);}}
        return new Api("your task status updated "); }

    @GetMapping("/task/search")
    public Api getTasksByTitle(@RequestParam String title){
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(title)){
                tasks.get(i);}}
        return new Api("this is your search");}
}
