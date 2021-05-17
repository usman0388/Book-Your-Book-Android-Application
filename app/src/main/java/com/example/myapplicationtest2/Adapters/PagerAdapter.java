package com.example.myapplicationtest2.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplicationtest2.CustomClasses.book;
import com.example.myapplicationtest2.tab1;
import com.example.myapplicationtest2.tab2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;
    int data = 1;
    List<book> bookList;

    public PagerAdapter(FragmentManager fm, int tabNum){
        super(fm);
        this.numberOfTabs = tabNum;
        inIt();
    }


    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new tab1(bookList);
        }else if(position ==1) {
            return new tab2(bookList);
        }else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull @NotNull Object object) {
        return POSITION_NONE;
    }
    private void inIt() {
        bookList = new ArrayList<>();
        ArrayList<String> tempArrayList = new ArrayList<>();
        tempArrayList.add("Science Fiction");
        tempArrayList.add("Fantasy");
        tempArrayList.add("Fiction");
        tempArrayList.add("Horror");
        tempArrayList.add("Young Adult");
        tempArrayList.add("Historical");
        tempArrayList.add("Adventure");
        bookList.add(new book(1,
                "Boneshaker",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1433161048l/1137215._SY475_.jpg",
                3.52f,
                "In the early days of the Civil War, rumors of gold in the frozen Klondike brought hordes of newcomers to " +
                        "the Pacific Northwest. Anxious to compete, Russian prospectors " +
                        "commissioned inventor Leviticus Blue to create a great machine that could mine through Alaska’s ice. Thus was " +
                        "Dr. Blue’s Incredible Bone-Shaking Drill Engine born.\n" +
                        "\n" +
                        "But on its first test run the Boneshaker went terribly awry, destroying several blocks of downtown Seattle and " +
                        "unearthing a subterranean vein of blight gas that turned anyone who breathed it into the living dead.\n" +
                        "\n" +
                        "Now it is sixteen years later, and a wall has been built to enclose the devastated and toxic city. Just beyond it" +
                        " lives Blue’s widow, Briar Wilkes. Life is hard with a ruined reputation and a teenaged boy to support, but she and " +
                        "Ezekiel are managing. Until Ezekiel undertakes a secret crusade to rewrite history.\n" +
                        "\n" +
                        "His quest will take him under the wall and into a city teeming with ravenous undead, air pirates, criminal overlords, " +
                        "and heavily armed refugees. And only Briar can bring him out alive.",10,"Cherie Priest",tempArrayList));
        tempArrayList = new ArrayList<>();
        tempArrayList.add("Science Fiction");
        tempArrayList.add("Fantasy");
        tempArrayList.add("Fiction");
        tempArrayList.add("Horror");
        tempArrayList.add("Time Travel");
        tempArrayList.add("Historical");
        tempArrayList.add("Adventure");
        bookList.add(new book(2,
                "The Anubis Gates",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1344409006l/142296.jpg",
                3.92f,
                "Brendan Doyle, a specialist in the work of the early-nineteenth century poet William Ashbless, " +
                        "reluctantly accepts an invitation from a millionaire to act as a guide to time-travelling tourists. " +
                        "But while attending a lecture given by Samuel Taylor Coleridge in 1810, he becomes marooned in Regency London, " +
                        "where dark and dangerous forces know about the gates in time.\n" +
                        "\n" +
                        "Caught up in the intrigue between rival bands of beggars, pursued by Egyptian sorcerers, and befriended by " +
                        "Coleridge, Doyle somehow survives and learns more about the mysterious Ashbless than he could ever have imagined " +
                        "possible...",15,"Tim Powers",tempArrayList));
        tempArrayList = new ArrayList<>();
        tempArrayList.add("Science Fiction");
        tempArrayList.add("Fantasy");
        tempArrayList.add("Fiction");
        tempArrayList.add("Horror");
        tempArrayList.add("Time Travel");
        tempArrayList.add("Historical");
        tempArrayList.add("Adventure");
        bookList.add(new book(3,
                "Clementine",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1277163268l/7670800.jpg",
                3.71f,
                "Maria Isabella Boyd’s success as a Confederate spy has made her too famous for further espionage work, and now her employment options are slim. Exiled, widowed, and on the brink of poverty…she reluctantly goes to work for the Pinkerton National Detective Agency in Chicago.\n" +
                        "\n" +
                        "Adding insult to injury, her first big assignment is commissioned by the Union Army. In short, a federally sponsored transport dirigible is being violently pursued across the Rockies and Uncle Sam isn’t pleased. The Clementine is carrying a top secret load of military essentials—essentials which must be delivered to Louisville, Kentucky, without delay.\n" +
                        "\n" +
                        "Intelligence suggests that the unrelenting pursuer is a runaway slave who’s been wanted by authorities on both sides of the Mason-Dixon for fifteen years. In that time, Captain Croggon Beauregard Hainey has felonied his way back and forth across the continent, leaving a trail of broken banks, stolen war machines, and illegally distributed weaponry from sea to shining sea.\n" +
                        "\n" +
                        "And now it’s Maria’s job to go get him.\n" +
                        "\n" +
                        "He’s dangerous quarry and she’s a dangerous woman, but when forces conspire against them both, they take a chance and form an alliance. She joins his crew, and he uses her connections. She follows his orders. He takes her advice.\n" +
                        "\n" +
                        "And somebody, somewhere, is going to rue the day he crossed either one of them.",12,"Cherie Priest",tempArrayList));

        tempArrayList = new ArrayList<>();
        tempArrayList.add("Science Fiction");
        tempArrayList.add("Fantasy");
        tempArrayList.add("Fiction");
        tempArrayList.add("Horror");
        tempArrayList.add("Time Travel");
        tempArrayList.add("Historical");
        tempArrayList.add("Adventure");
        tempArrayList.add("Westerns");
        bookList.add(new book(4,
                "The Buntline Special",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1284431932l/8253037.jpg",
                3.46f,
                "Welcome to a West like you've never seen before, where electric lights shine down on the streets of Tombstone, while horseless stagecoaches carry passengers to and fro, and where death is no obstacle to The Thing That Was Once Johnny Ringo. Think you know the story of the O.K. Corral? Think again, as five-time Hugo " +
                        "winner Mike Resnick takes on his first steampunk western tale, and the West will never be the same.",5,"Mike Resnick",tempArrayList));
        tempArrayList = new ArrayList<>();
        tempArrayList.add("Science Fiction");
        tempArrayList.add("Fantasy");
        tempArrayList.add("Fiction");
        tempArrayList.add("Horror");
        tempArrayList.add("Time Travel");
        tempArrayList.add("Historical");
        tempArrayList.add("Romance");
        tempArrayList.add("New Adult");
        tempArrayList.add("Paranormal");
        tempArrayList.add("Magic");
        tempArrayList.add("Young Adult");
        bookList.add(new book(5,
                "The Crown of Gilded Bones",
                "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1606759553l/55240343._SY475_.jpg",
                4.38f,
                "She's been the victim and the survivor…\n" +
                        "\n" +
                        "Poppy never dreamed she would find the love she’s found with Prince Casteel. She wants to revel in her happiness but first they must free his brother and find hers. It’s a dangerous mission and one with far-reaching consequences neither dreamed of. Because Poppy is the Chosen, the Blessed. The true ruler of Atlantia. She carries the blood of the King of Gods within her. By right the crown and the kingdom are hers.\n" +
                        "\n" +
                        "The enemy and the warrior…\n" +
                        "\n" +
                        "Poppy has only ever wanted to control her own life, not the lives of others, but now she must choose to either forsake her birthright or seize the gilded crown and become the Queen of Flesh and Fire. But as the kingdoms’ dark sins and blood-drenched secrets finally unravel, a long-forgotten power rises to pose a genuine threat. And they will stop at nothing to ensure that the crown never sits upon Poppy’s head.\n" +
                        "\n" +
                        "A lover and heartmate…\n" +
                        "\n" +
                        "But the greatest threat to them and to Atlantia is what awaits in the far west, where the Queen of Blood and Ash has her own plans, ones she has waited hundreds of years to carry out. Poppy and Casteel must consider the impossible—travel to the Lands of the Gods and wake the King himself. And as shocking secrets and the harshest betrayals come to light, and enemies emerge to threaten everything Poppy and Casteel have fought for, they will discover just how far they are willing to go for their people—and each other.\n" +
                        "\n" +
                        "And now she will become Queen…",18," Jennifer L. Armentrout",tempArrayList));

    }
}
