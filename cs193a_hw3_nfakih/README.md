# Mad Libs
Program Description and Functionality Requirements:
"Mad Libs" are short stories that have blanks called placeholders to be filled in. In the non-computerized version of this game, one person asks a second person to fill in each of the placeholders without the second person knowing the overall story. Once all placeholders are filled in, the second person is shown the resulting silly story.

For this assignment, write an Android app that reads in a Mad Lib from a text file in a specific format. The text file represents placeholders as tokens that start and end with < > brackets, like <adjective> or <proper noun>. Your app reads the file, looks for any such placeholders, and prompts the user to replace them with specific words. Once the user has typed in replacements for all placeholders, the completed story is shown on the screen.

Since one of the main goals of this assignment is to practice writing an app with multiple activities, we require you to have at least the following three activities in your app:
- MainActivity: An initial "welcome" screen explaining the app.
- FillInWordsActivity: a screen that repeatedly prompts the user to fill in placeholders.
- ShowStoryActivity: a third activity to display the completed story.
