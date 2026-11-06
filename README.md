# OpenShift Spring Boot Practice

Java 17 + Spring Boot sample for practising GitHub -> Docker build -> OpenShift Serverless deployment.

Endpoints:
- `/` returns a welcome JSON response.
- `/health` returns `{"status":"UP"}`.
- `/actuator/health` is enabled.

## Push to GitHub from Windows CMD

1. Extract this ZIP.
2. Create an empty GitHub repository named `openshift-springboot-practice` (do not add README or .gitignore).
3. Open CMD **inside the extracted project folder**, where `pom.xml` and `Dockerfile` are located.
4. Run:

```bat
git init
git add .
git commit -m "Initial Spring Boot practice app"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/openshift-springboot-practice.git
git push -u origin main
```

Replace `YOUR_USERNAME` with your GitHub username and use your actual repository URL.

If `remote origin already exists`:
```bat
git remote set-url origin https://github.com/YOUR_USERNAME/openshift-springboot-practice.git
git push -u origin main
```

**Important:** Run `git init` only in this project folder, not in Downloads, Desktop, or a parent folder.

## Import into OpenShift

1. Select your own Developer Sandbox project/namespace (not `default` if it causes permission errors).
2. Choose **Add -> Import from Git** and paste the repository URL.
3. Select the Dockerfile build strategy.
4. Set target port to `8080`.
5. Create the application. Serverless/Knative is optional; enable it if you want to practise Serverless.

## Make a change and deploy an update

Edit `src/main/java/com/practice/demo/StatusController.java` and change the welcome message.

Then run from the project folder:
```bat
git add .
git commit -m "Update homepage message"
git push
```

If a Git webhook is not configured, check the BuildConfig name and start a build in the OpenShift terminal:
```bash
oc get bc
oc start-build YOUR_BUILDCONFIG_NAME --follow
```

Verify:
```bash
oc get builds
oc get ksvc
```
Open the URL from `oc get ksvc` and visit `/` or `/health`.
