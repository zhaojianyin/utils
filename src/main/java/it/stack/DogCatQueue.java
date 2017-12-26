package it.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @项目名称：util
 * @类名称：DogCatQueue @类描述： 猫狗队列，
 *
 * @author 赵建银
 * @date 2017年12月27日
 * @time 下午6:08:03
 * @version 1.0
 */
public class DogCatQueue {

	private Queue<PetEnter> dogQ;
	private Queue<PetEnter> catQ;
	private long count;

	public DogCatQueue() {
		this.dogQ = new LinkedList<PetEnter>();
		this.catQ = new LinkedList<PetEnter>();
	}

	public void add(Pet pet) {
		if (pet.getType().equals("dog")) {
			PetEnter petEnter = new PetEnter(pet, this.count++);
			dogQ.add(petEnter);
		} else if (pet.getType().equals("cat")) {
			PetEnter petEnter = new PetEnter(pet, this.count++);
			catQ.add(petEnter);
		} else {
			throw new RuntimeException("类型不匹配");
		}
	}

	/**
	 * 注意：当某个队列为空时将剩下的队列全部按顺序poll
	 * 
	 * @return
	 */
	public Pet pollAll() {
		if (this.isEmpty()) {
			if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
				return this.dogQ.poll().getPet();
			} else {
				return this.catQ.poll().getPet();
			}
		} else if (this.dogQ.isEmpty()) {
			return this.catQ.poll().getPet();
		} else if (this.catQ.isEmpty()) {
			return this.dogQ.poll().getPet();
		} else {
			throw new RuntimeException("queue is empty");
		}
	}

	public Pet pollDog() {
		if (!this.isDogEmpty()) {
			return this.dogQ.poll().getPet();
		} else {
			throw new RuntimeException("Dog queue is empty");
		}
	}

	public Pet pollCat() {
		if (!this.isCatEmpty()) {
			return this.catQ.poll().getPet();
		} else {
			throw new RuntimeException("cat queue is empty");
		}
	}

	public boolean isEmpty() {
		return this.dogQ.isEmpty() && this.catQ.isEmpty();
	}

	public boolean isDogEmpty() {
		return this.dogQ.isEmpty();
	}

	public boolean isCatEmpty() {
		return this.catQ.isEmpty();
	}

}

class Pet {
	private String type;

	public String getType() {
		return type;
	}

	public Pet(String type) {
		this.type = type;
	}

}

class Cat extends Pet {
	public Cat() {
		super("Cat");
	}
}

class Dog extends Pet {
	public Dog() {
		super("Dog");
	}
}

class PetEnter {
	private Pet pet;
	private long count;// 时间戳

	public PetEnter(Pet pet, long count) {
		super();
		this.pet = pet;
		this.count = count;
	}

	public Pet getPet() {
		return pet;
	}

	public long getCount() {
		return count;
	}
}
