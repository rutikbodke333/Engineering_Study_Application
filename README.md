# Engineering Study Application
 

![SpringBoot](https://img.shields.io/badge/SpringBoot-2.7-green)  
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)  
![JPA](https://img.shields.io/badge/JPA-Hibernate-orange)  
![GitHub](https://img.shields.io/badge/GitHub-VersionControl-black)  
![Postman](https://img.shields.io/badge/Postman-API%20Testing-orange)  

 

# 🚀 The Challenge

Meet **Pranvi**, a dedicated engineering student who’s passionate about helping her peers learn and grow.  
She wants to share _**study materials**_, _**announcements**_, and handy tools like a _**percentage-to-CGPA converter**_ with her community.

But managing everything through scattered **files**, **group chats**, and **emails** is becoming overwhelming and inefficient.

That’s where **you** come in!  
As a _**backend developer**_, it’s your mission to build a powerful _**Engineering Study Application**_ that helps Pranvi stay organized and productive.

With your skills, she can focus on supporting her peers—without getting lost in digital clutter. 🎯


---

## Technologies Used  

- **Backend:** Spring Boot, JPA (Hibernate), RESTful APIs  
- **Database:** MySQL  
- **API Testing:** Postman  
- **Version Control:** Git & GitHub  

---

# 🎓 Engineering Study Application

A backend system designed for **Pranvi**, an engineering student passionate about helping her peers by sharing study materials, announcements, and academic utilities like percentage-to-CGPA conversion.

---

## 📊 Understanding the Data

Pranvi needs two key entities in her system:

### 📂 _**Users**_
- **ID** (Unique identifier)  
- **Name**  
- **Email**  
- **Password**  
- **Role** (_USER_ / _ADMIN_)

### 📢 _**Announcements**_
- **ID** (Unique identifier)  
- **Title**  
- **Message**  
- **PostedBy** (User ID)

---

## 📡 API Endpoints

### 1️⃣ _**Register User**_  
- **📌 Endpoint:** `POST /engineeringstudy/auth/register`  
- **🛠️ Functionality:** Accepts user details and registers a normal user.  
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
![Register User](https://github.com/rutikbodke333/movie-review-system/blob/main/Returns%20a%20list%20of%20movies%20along%20with%20their%20reviews.png?raw=true)

---

### 2️⃣ _**Create User Profile (Admin)**_  
- **📌 Endpoint:** `POST /engineeringstudy/admin/users`  
- **🛠️ Functionality:** Allows admin to create user accounts with admin role.  
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
![Create User Admin](https://github.com/yourusername/your-repo-name/blob/main/path-to-create-user.png?raw=true)

---

### 3️⃣ _**Create Announcement (Admin)**_  
- **📌 Endpoint:** `POST /engineeringstudy/admin/announcements`  
- **🛠️ Functionality:** Admin can post a new announcement.  
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
![Create Announcement](https://github.com/yourusername/your-repo-name/blob/main/path-to-create-announcement.png?raw=true)

---

### 4️⃣ _**Get All Announcements**_  
- **📌 Endpoint:** `GET /engineeringstudy/announcements`  
- **🛠️ Functionality:** Returns all announcements visible to users.  
- **🧪 Tested with:** Postman

---

### 5️⃣ _**Upload PDF (User)**_  
- **📌 Endpoint:** `POST /engineeringstudy/user/documents`  
- **🛠️ Functionality:** Allows a user to upload a study document.  
- **🧪 Tested with:** Postman

---

### 6️⃣ _**Convert Percentage to CGPA (User)**_  
- **📌 Endpoint:** `GET /engineeringstudy/user/convert?percentage=85`  
- **🛠️ Functionality:** Returns CGPA equivalent of given percentage.  
- **🧪 Tested with:** Postman


---

