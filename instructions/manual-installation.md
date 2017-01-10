# Installing the SDK Manually via the SDK Builder.

Below are the step by step procedure on how to install the sdk on your new or existing project manually, below also shows the list of the requirements for the sdk to work properly.

## Requirements

- Java 8
- Android SDK (minimum version 14, target version 25)
- Android API 16 to 24 is the current support.
- Android Studio (or other IDE with the same functionality, we will use Android Studio for most of the examples).

#### Step 1. Go to the SDK Builder page.

For the first step, we need to download the sdk via the sdk builder site located at [globelabs.github.io](http://globelabs.github.io), select the platform and the api's that needs to be included in the sdk, in this case the platform that we need to use is android, after downloading the zip file that contains the sdk via the sdk builder site extract it then let's proceed to the next step where we are going to import the sdk to a new / existing android project.

### Step 2. Including the SDK to the project.

The contents of the extracted sdk zip file should look like this:
![Extracted SDK](manual/step-2-a.png)

After extracting the sdk zip file, let's include the sdk on our project, on the left side of your Android Studio IDE select Project > Android, it will show the minified structure of your project, Right Click on your App folder > Open Module Settings, it should look like this:
![Module Settings](manual/step-2-b.png)

after clicking the Open Module Settings a new pop-up window should show that looks like this:
![Module Settings window](manual/step-2-c.png)

now let's add a module by clicking on the plus sign located at the top left most of the module settings window, after clicking the plus sign, a new pop-up window should show up and it should look something like this:
![New Module window](manual/step-2-d.png)

select Import Gradle Project, we are going to import the sdk as a Gradle Project, then hit Next, it should show a new window that ask for the module's source directory, locate the sdk's "api" folder and hit "OK".
![Locate SDK](manual/step-2-e.png)

set the module name, this should be unique and is related to the module that we are going to import, we're going to use :globeconnect as the module name, the ":" prefix is required because of gradle so you should always prefix the module name with ":", after putting the module name, hit "Finish" then let's proceed to the next step.
![Set Module Name](manual/step-2-f.png)

### Step 3. Setting the SDK as Project Dependency.
