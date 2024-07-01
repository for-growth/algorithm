package programmers.repeat1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class lv2_과제진행하기 {
    public static void main(String[] args) throws IOException {

    }

    private static String[] Solution(String[][] plans) {

        List<String> answer = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            String[] split = plans[i][1].split(":");
            int hour = Integer.parseInt(split[0]);
            int minutes = Integer.parseInt(split[1]);
            int start = (hour * 60) + minutes;

            int time = Integer.parseInt(plans[i][2]);

            pq.add(new Node(name, start, time));
        }

        Stack<Node> wait = new Stack<>();

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            String curName = now.name;
            int curStart = now.start;
            int curPlayTime = now.time;

            int currentTime = curStart;

            if (!pq.isEmpty()) {
                Node next = pq.peek();
                if (currentTime + curPlayTime < next.start) {
                    answer.add(curName);
                    currentTime += curPlayTime;

                    while (!wait.isEmpty()) {
                        Node waitNode = wait.pop();

                        if (currentTime + waitNode.time <= next.start) {
                            currentTime += waitNode.time;
                            answer.add(waitNode.name);
                            continue;
                        } else {
                            int t = waitNode.time - (next.start - currentTime);
                            wait.push(new Node(waitNode.name, waitNode.start, t));

                        }
                    }
                }
            }
        }

        return null;
    }

    private static class Node implements Comparable<Node> {
        String name;
        int start;
        int time;

        public Node(String name, int start, int time) {
            this.name = name;
            this.start = start;
            this.time = time;
        }



        @Override
        public int compareTo(Node o) {
            return start - o.start;
        }
    }


    public static class lv2_과제진행하기_2 {
        public static void main(String[] args) {
            String[][] plans = {{"aaa", "12:00", "20"},{"bbb", "12:10", "30"},{"ccc", "12:40", "10"}};

            PriorityQueue<Node> queue = new PriorityQueue<>();
            Stack<Node> wait = new Stack<>();
            for(int i=0;i<plans.length;i++){
                String[] s = plans[i][1].split(":");
                int time = stoi(s[0]) * 60 + stoi(s[1]);
                queue.add(new Node(plans[i][0], time, stoi(plans[i][2])));
            }
            ArrayList<String> answer = new ArrayList<>();

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                String curName = now.name;
                int curStart = now.start;
                int curPlayTime = now.time;

                int currentTime = curStart;
                //과제가 큐에 남아 있는경우
                if (!queue.isEmpty()) {
                    Node next = queue.peek();
                    //지금 과제를 끝내고도 시간이 남는 경우.
                    if(currentTime + curPlayTime <= next.start){
                        answer.add(curName);
                        currentTime += curPlayTime;

                        while (!wait.isEmpty()) {
                            Node node = wait.pop();
                            if (currentTime + node.time <= next.start) {
                                currentTime += node.time;
                                answer.add(node.name);
                            }else{
                                wait.push(new Node(node.name, node.start, node.time - (next.start - currentTime)));
                                break;
                            }
                        }
                    }else{
                        int time = now.time - (next.start - currentTime);
                        wait.push(new Node(now.name, now.start, time));
                    }
                }
                //과제가 큐에 남아있지 않은 경우
                else{
                    //남아있는 대기스택이 없는 경우
                    if (wait.isEmpty()) {
                        answer.add(now.name);
                    }
                    //대기 과제가 있는 경우
                    else{
                        answer.add(now.name);
                        while (!wait.isEmpty()) {
                            answer.add(wait.pop().name);
                        }
                    }
                }
            }
            System.out.println(answer.toString());
        }

        static int stoi(String s) {
            return Integer.parseInt(s);
        }

        static class Node implements Comparable<Node>{
            String name;
            int start;
            int time;

            public Node(String name, int start, int end) {
                this.name = name;
                this.start = start;
                this.time = end;
            }

            @Override
            public int compareTo(Node o){
                return this.start - o.start;
            }
        }
    }
}
