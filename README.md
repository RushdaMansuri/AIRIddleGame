# AIRIddleGame

AIRIddleGame is an interactive Java console application that leverages the OpenAI API to generate riddles for the user to solve. It showcases the integration of advanced AI models into Java applications, providing a fun and engaging way to interact with AI-generated content.

## Features

- **Riddle Generation**: Generates intriguing riddles using OpenAI's powerful GPT models.
- **Interactive Gameplay**: Engages users in a simple and interactive guessing game.
- **Hints and Answers**: Offers hints for each riddle and validates user guesses.

## Getting Started

Follow these instructions to get a copy of AIRIddleGame up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) 11 or newer.
- An active OpenAI API key.

### Installation

1. **Clone the Repository**

   ```sh
   git clone https://github.com/RushdaMansuri/AIRIddleGame.git

2. **Set Up Your OpenAI API Key**

    For security reasons, it's recommended to use an environment variable for your OpenAI API key.      Replace YOUR_API_KEY with your actual OpenAI API key.


    ```sh
    export OPENAI_API_KEY='YOUR_API_KEY'

3. **Build the Project**

    Navigate to the project directory and compile the Java files.

    ```sh
    cd AIRIddleGame
    javac -d bin src/*.java

Ensure you include the necessary libraries in your classpath when compiling and running the application.

## Running the Application
To start the game, run the compiled Java class from the command line.

    ```sh
    java -cp bin:PATH_TO_JSON_LIBRARY RiddleGame

Replace PATH_TO_JSON_LIBRARY with the path to the JSON processing library you are using (e.g., json-20210307.jar).

## Usage
After starting the application, follow the on-screen prompts to interact with the game:

- Read the riddle presented.
- Type your guess and press Enter.
- Request a hint if you're stuck.
- Continue playing with new riddles or exit the game as desired.

## Contributing
Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

1. Fork the Project
2. Create your Feature Branch (git checkout -b feature/AmazingFeature)
3. Commit your Changes (git commit -m 'Add some AmazingFeature')
4. Push to the Branch (git push origin feature/AmazingFeature)
5. Open a Pull Request

## Contact
Rushda Mansuri - https://www.linkedin.com/in/rushda-mansuri-a14a3984/

Project Link: https://github.com/RushdaMansuri/AIRIddleGame



