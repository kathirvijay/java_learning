import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    String selection[] = new String[5];

    public QuestionService(){
        questions[0] = new Question(1, "what name start with k?", "kathir", "nandha", "pradee", "alice", "kathir");
        questions[1] = new Question(1, "what name start with n?", "kathir", "nandha", "pradee", "alice", "nandha");
        questions[2] = new Question(1, "what name start with p?", "kathir", "nandha", "pradee", "alice", "pradee");
        questions[3] = new Question(1, "what name start with a?", "kathir", "nandha", "pradee", "alice", "alice");
        questions[4] = new Question(1, "what name start with l?", "kathir", "nandha", "pradee", "alice", "not there");

    }

    public void displayQuestions() {
        for(Question q: questions) {
            System.out.println("in display question  -  "+ q);
        }
    }

        public void playQuiz() {
            int i = 0;
            int j = 0;
            int score = 0;
            for(Question q: questions) {
                System.out.println("Question no  -  "+ q.getId());
                System.out.println( q.getQuestion());
                System.out.println(q.getOpt1());
                System.out.println(q.getOpt2());
                System.out.println(q.getOpt3());
                System.out.println(q.getOpt4());
                Scanner sc = new Scanner(System.in);
                selection[i] = sc.nextLine();
                i++;
    
        }

        for(String s : selection){
            System.out.println("Output  - " +s);
            System.out.println("j  - " +j);
            if(s.equals(questions[j].getAnswer())){
                score++;
            }
            j++;
        }

        System.out.println("Total score - "+ score +"/"+ j);
    }
}
