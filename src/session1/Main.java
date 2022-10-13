package session1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<>();
        hs.add("Hello");
        hs.add("world");
        hs.add("Hello");
        hs.add("world");
        for (String s : hs){
            System.out.println(s);
        }

        PriorityQueue<Integer> number = new PriorityQueue<>();
        number.add(4);
        number.add(2);
        number.add(1);
        System.out.println("Number: "+number);

        int first = number.peek(); // ham peek la ham lay phan tu dau tien
        System.out.println("first: "+first);
        System.out.println("Total: "+number.size());

        // ham poll la ham lay phan tu dau tien va xoa bo luon
        System.out.println("Poll: "+number.poll()+" remain: "+number.size());
        System.out.println("Poll: "+number.poll()+" remain: "+number.size());
        System.out.println("Poll: "+number.poll()+" remain: "+number.size());


        PriorityQueue<Student> s = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getMark() - o1.getMark();
            }
        });
        s.add(new Student("Nguyễn Tuấn Anh", 4));
        s.add(new Student("Nguyễn Văn An", 7));
        s.add(new Student("Phạm Minh Hùng", 9));
        s.add(new Student("Triệu Sơn Việt", 1));
        Student st;
        while (s.size()>0){
            st = s.poll();
            System.out.println("SV: "+st.getName()+" --Điểm thi: "+ st.getMark());
        }

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Good student",10);
        hm.put("Bad student",3);
        System.out.println("Tiêu chuẩn sinh viên xuất sắc là: "+hm.get("Good student"));
        System.out.println(hm.keySet());
        System.out.println(hm.values());

    }
}
