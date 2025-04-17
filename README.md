<h1 align="center" font-style="bold">
  $\Huge\textnormal{\color{aqua}Hydration Tracker}$
</h1>

$$\textnormal{\color{red}(I heard you don't drink enough water!)}$$
<br>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/Object--Oriented%20Programming-%2300A896?style=for-the-badge)
![GitHub](https://img.shields.io/badge/Version%20Control-GitHub-orange?style=for-the-badge&logo=github)
![Role-Based Access](https://img.shields.io/badge/Access%20Control-Role--Based-%23008CBA?style=for-the-badge)
![Project Status](https://img.shields.io/badge/Project-Active-green?style=for-the-badge)

<br>

<p align="center">A simple and effective hydration system to track water intake, set goals, and get reminders!</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/f4709f88-11a4-4663-8ec7-eea8aa6d5a6c" alt="App Screenshot" width=250>
</p>


<details>
  <summary align="center">
    <h1 align="center">
      $\textnormal{\color{gold}{FILE STRUCTURE}}$
    </h1><br>
  </summary>
  
```
src
├── About/
│   ├── About.java
│   └── WaterIntakeChart.java
│
├── Codes/       
│   ├── Feedback.java
│   ├── FileManager.java
│   ├── Graph.java
│   ├── PrintManager.java
│   ├── Reminder.java
│   ├── Tracker.java
│   ├── User.java
│   └── UserDataIndex.java
│
├── Dashboard/
│   ├── AdminDashboard.java
│   ├── UserDashboard.java
│   └── UserSession.java
│
├── Interfaces/
│   ├── IFileManager.java
│   ├── IPrintManager.java
│   └── ITracker.java
│
├── Utils/
│   ├── Color.java
│   ├── MyFileUtils.java
│   └── MyGeneralUtils.java
│
├── Txt_Files/
│   ├── feedback.txt
│   └── water_stats.txt
│
├── Sound/
│   └── reminder.wav
│
├── App/
│   └── App.java
```

</details>

<details>
  <summary align="center">
    <h1 align="center">
      $\textnormal{\color{aquamarine}{INSTALLATION}}$
    </h1>
  </summary>

1. Clone the repository:
   ```diff
   git clone https://github.com/ridika-2004/Hydration-Tracker.git
   ```

2. Compile the Java files:
   ```diff
   javac -d bin src/**/*.java
   ```

3. Run the application:
   ```diff
   java -cp bin App.App
   ```

</details>

<details>
  <summary align="center">
    <h1>$\textnormal{\color{greenyellow}{FEATURES}}$</h1>
  </summary>

<img src="https://github.com/user-attachments/assets/ef2c2486-3d9c-46b2-a062-b559e5093dbc" alt="License" width="100" align="left" style="vertical-align: bottom;" />

<ul align="right">
  <p align= "right">Role-based login without authentication.</p>
  <p align= "right">Users can set water goal and see progress bar along with their history.</p>
  <p align= "right">Receive hydration reminder and send feedback to the admin.</p>
  <p align= "right">Admins can view feedbacks and login details.</p>
</ul>

</details>

<details>
  <summary align="center">
    <h1>$\textnormal{\color{orange}{TECH\ STACK}}$</h1>
  </summary>
<img src="https://github.com/user-attachments/assets/8d118f8d-31d5-4f50-9b56-e7b196910cdf" width="100" align="right" style="vertical-align: bottom;" />

<ul align="left">
  <p align="left">Java (Object-Oriented Programming)</p>
  <p align="left">Java I/O for file handling</p>
  <p align="left">Plain Text files for data storage</p>
  <p align="left">ASCII and Unicode characters for console UI</p>
</ul>
</details>

<details>
  <summary align="center">
    <h1>$\textnormal{\color{cyan}{HOW\ TO\ USE}}$</h1>
  </summary>
<img src="https://github.com/user-attachments/assets/c9b0d8b0-dcaf-4814-a904-8a847f137ff6" width="100" align="left" style="vertical-align: bottom;" />


<ul align="right">
  <p align="right">Set your role as admin or user.</p>
  <p align="right">Set your hydration goal and track daily intake.</p>
  <p align="right">Receive reminder alerts during the day.</p>
  <p align="right">View progress charts and submit feedback.</p>
</ul>
</details>

<h1 align="left"> $\textnormal{\color{red}{LICENSE}}$ </h1>
<img src="https://github.com/user-attachments/assets/e3f311ef-1d75-4da0-bcb1-dca8fb7e59d4" alt="License" width="100" align="right" style="vertical-align: bottom;" />
<p align="left">${This\ project\ is\ licensed\ under\ the \ {\color{red}MIT}}\ License$</p>
