/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.enespepelehazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import java.util.Random;
/**
 *
 * @author Lucifer
 */
public class EnesPepeleHazelCast {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();
    IMap<Integer, Integer> map = hazelcastInstance.getMap("myMap");
    Random rand = new Random();
    int numberOfEntries = 1235; // Deneme Amaçlı önce 20000 sonra 1235 adet random sayı gönderdim
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < numberOfEntries; i++) {
      map.put(i, rand.nextInt());
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Time to put " + numberOfEntries + " entries: " + (endTime - startTime) + "ms");
    startTime = System.currentTimeMillis();
    for (int i = 0; i < numberOfEntries; i++) {
      int key = rand.nextInt(numberOfEntries);
      int value = map.get(key);
    }
    endTime = System.currentTimeMillis();
    System.out.println("Time to get " + numberOfEntries + " entries: " + (endTime - startTime) + "ms");
	
    }
}