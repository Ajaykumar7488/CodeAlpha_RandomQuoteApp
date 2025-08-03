package com.example.randomquoteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var quoteText: TextView
    private lateinit var quoteAuthor: TextView
    private lateinit var newQuoteButton: Button

    val quotes = listOf(
        Quote("Be yourself; everyone else is already taken.", "Oscar Wilde"),
        Quote("In the middle of every difficulty lies opportunity.", "Albert Einstein"),
        Quote("Life is what happens when you're busy making other plans.", "John Lennon"),
        Quote("If you tell the truth, you don't have to remember anything.", "Mark Twain"),
        Quote("The best way to get started is to quit talking and begin doing.", "Walt Disney"),
        Quote("Success is not final, failure is not fatal: it is the courage to continue that counts.", "Winston Churchill"),
        Quote("Don't watch the clock; do what it does. Keep going.", "Sam Levenson"),
        Quote("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"),
        Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"),
        Quote("Your time is limited, so don't waste it living someone else's life.", "Steve Jobs"),
        Quote("Act as if what you do makes a difference. It does.", "William James"),
        Quote("Never bend your head. Always hold it high. Look the world straight in the eye.", "Helen Keller"),
        Quote("What you get by achieving your goals is not as important as what you become by achieving your goals.", "Zig Ziglar"),
        Quote("Dream big and dare to fail.", "Norman Vaughan"),
        Quote("You miss 100% of the shots you don’t take.", "Wayne Gretzky"),
        Quote("Keep your face always toward the sunshine—and shadows will fall behind you.", "Walt Whitman"),
        Quote("Hardships often prepare ordinary people for an extraordinary destiny.", "C.S. Lewis"),
        Quote("It does not matter how slowly you go as long as you do not stop.", "Confucius"),
        Quote("Everything you’ve ever wanted is on the other side of fear.", "George Addair"),
        Quote("You only live once, but if you do it right, once is enough.", "Mae West"),
        Quote("Turn your wounds into wisdom.", "Oprah Winfrey"),
        Quote("The only limit to our realization of tomorrow is our doubts of today.", "Franklin D. Roosevelt"),
        Quote("It always seems impossible until it's done.", "Nelson Mandela"),
        Quote("Do what you can, with what you have, where you are.", "Theodore Roosevelt"),
        Quote("Keep going. Everything you need will come to you at the perfect time.", "Unknown"),
        Quote("Work hard in silence, let your success be your noise.", "Frank Ocean"),
        Quote("You become what you believe.", "Oprah Winfrey"),
        Quote("Little by little, one travels far.", "J.R.R. Tolkien"),
        Quote("The secret of getting ahead is getting started.", "Mark Twain"),
        Quote("We may encounter many defeats but we must not be defeated.", "Maya Angelou"),
        Quote("It is never too late to be what you might have been.", "George Eliot"),
        Quote("All our dreams can come true if we have the courage to pursue them.", "Walt Disney"),
        Quote("Don't be pushed around by the fears in your mind. Be led by the dreams in your heart.", "Roy T. Bennett"),
        Quote("You are never too old to set another goal or to dream a new dream.", "C.S. Lewis"),
        Quote("Push yourself, because no one else is going to do it for you.", "Unknown"),
        Quote("Success doesn’t just find you. You have to go out and get it.", "Unknown"),
        Quote("Great things never come from comfort zones.", "Unknown"),
        Quote("Dream it. Wish it. Do it.", "Unknown"),
        Quote("Stay focused and never give up.", "Unknown"),
        Quote("Don't limit your challenges. Challenge your limits.", "Unknown"),
        Quote("Doubt kills more dreams than failure ever will.", "Suzy Kassem"),
        Quote("Everything you can imagine is real.", "Pablo Picasso"),
        Quote("I can and I will. Watch me.", "Carrie Green"),
        Quote("The harder you work for something, the greater you’ll feel when you achieve it.", "Unknown"),
        Quote("Dream bigger. Do bigger.", "Unknown"),
        Quote("Do something today that your future self will thank you for.", "Sean Patrick Flanery"),
        Quote("Don't stop until you're proud.", "Unknown"),
        Quote("Difficult roads often lead to beautiful destinations.", "Zig Ziglar"),
        Quote("The only way to do great work is to love what you do.", "Steve Jobs"),
        Quote("It’s going to be hard, but hard does not mean impossible.", "Unknown"),
        Quote("Sometimes later becomes never. Do it now.", "Unknown"),
        Quote("The key to success is to focus on goals, not obstacles.", "Unknown"),
        Quote("Wake up with determination. Go to bed with satisfaction.", "George Lorimer"),
        Quote("If you can dream it, you can do it.", "Walt Disney"),
        Quote("Opportunities don't happen. You create them.", "Chris Grosser"),
        Quote("Don’t wait for opportunity. Create it.", "George Bernard Shaw"),
        Quote("Try not to become a man of success, but rather try to become a man of value.", "Albert Einstein"),
        Quote("I find that the harder I work, the more luck I seem to have.", "Thomas Jefferson"),
        Quote("Success usually comes to those who are too busy to be looking for it.", "Henry David Thoreau"),
        Quote("Don’t be afraid to give up the good to go for the great.", "John D. Rockefeller"),
        Quote("If you are not willing to risk the usual, you will have to settle for the ordinary.", "Jim Rohn"),
        Quote("Success is walking from failure to failure with no loss of enthusiasm.", "Winston Churchill"),
        Quote("Try again. Fail again. Fail better.", "Samuel Beckett"),
        Quote("Never give up on a dream just because of the time it will take to accomplish it.", "Earl Nightingale"),
        Quote("If people are doubting how far you can go, go so far that you can’t hear them anymore.", "Michele Ruiz"),
        Quote("We generate fears while we sit. We overcome them by action.", "Dr. Henry Link"),
        Quote("Don’t let yesterday take up too much of today.", "Will Rogers"),
        Quote("The man who has confidence in himself gains the confidence of others.", "Hasidic Proverb"),
        Quote("Whether you think you can or think you can’t, you’re right.", "Henry Ford"),
        Quote("What lies behind us and what lies before us are tiny matters compared to what lies within us.", "Ralph Waldo Emerson"),
        Quote("It’s not whether you get knocked down. It’s whether you get up.", "Vince Lombardi"),
        Quote("Perseverance is not a long race; it is many short races one after another.", "Walter Elliot"),
        Quote("A winner is a dreamer who never gives up.", "Nelson Mandela"),
        Quote("Don't count the days, make the days count.", "Muhammad Ali"),
        Quote("Only those who dare to fail greatly can ever achieve greatly.", "Robert F. Kennedy"),
        Quote("You can’t cross the sea merely by standing and staring at the water.", "Rabindranath Tagore"),
        Quote("Success is how high you bounce when you hit bottom.", "George S. Patton"),
        Quote("The journey of a thousand miles begins with one step.", "Lao Tzu"),
        Quote("Do not wait to strike till the iron is hot; but make it hot by striking.", "William Butler Yeats"),
        Quote("What you do today can improve all your tomorrows.", "Ralph Marston"),
        Quote("Start where you are. Use what you have. Do what you can.", "Arthur Ashe"),
        Quote("The only person you are destined to become is the person you decide to be.", "Ralph Waldo Emerson"),
        Quote("Failure will never overtake me if my determination to succeed is strong enough.", "Og Mandino"),
        Quote("Don't wish it were easier. Wish you were better.", "Jim Rohn"),
        Quote("If you're going through hell, keep going.", "Winston Churchill"),
        Quote("A person who never made a mistake never tried anything new.", "Albert Einstein"),
        Quote("If you change the way you look at things, the things you look at change.", "Wayne Dyer"),
        Quote("We become what we think about.", "Earl Nightingale"),
        Quote("You don't need to see the whole staircase, just take the first step.", "Martin Luther King Jr."),
        Quote("Magic is believing in yourself. If you can do that, you can make anything happen.", "Johann Wolfgang von Goethe")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteText = findViewById(R.id.quoteText)
        quoteAuthor = findViewById(R.id.quoteAuthor)
        newQuoteButton = findViewById(R.id.newQuoteButton)

        showRandomQuote()

        newQuoteButton.setOnClickListener {
            showRandomQuote()
        }
    }

    private fun showRandomQuote() {
        val randomQuote = quotes[Random.nextInt(quotes.size)]
        quoteText.text = "\"${randomQuote.text}\""
        quoteAuthor.text = "- ${randomQuote.author}"
    }
}
