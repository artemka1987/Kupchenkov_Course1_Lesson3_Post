import java.util.Date;
import java.util.Random;

/**
 * Created by Artemka on 06.09.2017.
 */
public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Post[] posts = new Post[7];

        //Заполняем массив
        for (int i = 0; i < posts.length; i++){
            posts[i] = new Post(random.nextLong(), "Title" + random.nextInt(100), "Text" + random.nextInt(100), new Date(2017 - 1900, random.nextInt(12), random.nextInt(29)));
        }

        //Сортируем по postId и выводим на экран
        arraySortBubbleByPostId(posts);
        printPosts(posts);

        System.out.println("");

        //Сортируем по postedAt и выводим на экран
        arraySortBubbleByPostedAt(posts);
        printPosts(posts);

    }




    //Сортировка пузырьком по postId
    private static void arraySortBubbleByPostId(Post[] posts){
        Post tmpPost = new Post();
        for (int i = 0; i < posts.length -1; i++){
            for (int j = 1; j < posts.length - i; j++){
                if (posts[j - 1].getPostId() > posts[j].getPostId()){
                    tmpPost = posts[j];
                    posts[j] = posts[j - 1];
                    posts[j - 1] = tmpPost;
                }
            }
        }
    }

    //Сортировка пузырьком по postedAt
    private static void arraySortBubbleByPostedAt(Post[] posts){
        Post tmpPost = new Post();
        for (int i = 0; i < posts.length -1; i++){
            for (int j = 1; j < posts.length - i; j++){
                if (posts[j - 1].getPostedAt().after(posts[j].getPostedAt())){
                    tmpPost = posts[j];
                    posts[j] = posts[j - 1];
                    posts[j - 1] = tmpPost;
                }
            }
        }
    }

    //Метод вывода массива на экран
    private static void printPosts(Post[] posts){
        for (int i = 0; i < posts.length; i++){
            System.out.println(posts[i]);
        }
    }


}
