describe('Evernote', () => {
    
    it('Identify App Type', async() => {

        const context = await driver.getContext();

        console.log(context);
        
    });

    it('App', async() => {

        await driver.pause(5000);
         // Continue with log in
          const login = await $ ('android=new UiSelector().className("android.view.ViewGroup").instance(10)')
          await login.click();
        // Input Email
        const email = await $('android=new UiSelector().resourceId("email")');
        // await email.click();
        await email.setValue('sharmilabnkwb@gmail.com');
        // Tap on continueButton
        await $('android=new UiSelector().text("Continue")').click();  
         // Input Password
        const pass = await $('android=new UiSelector().className("android.widget.EditText").instance(1)')
        await pass.setValue('Simran2506');
        // Dismiss the keyboard
        // await driver.dismissKeyboard();
        await $('android=new UiSelector().className("android.view.View").instance(3)').click();
        // Tap on continueButton
        const contine =  await $('android=new UiSelector().text("Continue")')
        await contine.click();
        // Wait for the home page to load
        await driver.pause(5000);
        
         // Click on Notes link 
         const note = await $('android=new UiSelector().className("android.view.ViewGroup").instance(80)')
         await note.click();
         // Create a note
         const creation = await $('android=new UiSelector().text("Create a note")')
         await creation.click();
         // Name one note
         const naming = await $('android=new UiSelector().className("android.widget.EditText").instance(0)')
         await naming.setValue('Construct Week3');
         await driver.pause(1000);
         // Start Writing
        //  const write = await $('android=new UiSelector().text("Start writing")')
        //  await write.setValue('Let us work hard.');
         // Navigate back 
         await driver.pressKeyCode(4);
         await driver.pause(1000);
         const back0 = await $('android=new UiSelector().className("android.widget.ImageView").instance(0)').click();
         await driver.pause(1000);
         const back1 = await $('android=new UiSelector().className("android.widget.ImageView").instance(0)').click();
        //  await driver.pause(2000);
         // Back to Create
         const home = await $('android=new UiSelector().className("android.view.ViewGroup").instance(81)')
         await home.click();
         await driver.pause(5000);
          // Search for notes
          const s1 = await $('android=new UiSelector().text("Find any note, task or document")')
          await s1.click();
          const s2 = await $('android=new UiSelector().resourceId("SEARCH_ITEM")')
          await s2.setValue('Pro');
         
          await $('android=new UiSelector().className("android.widget.ImageView").instance(1)').click();
          await driver.pause(2000);
          // Assertion
          const pro = await $('~PROJECT');
          await expect(pro).toBeExisting();

          // Deleting the note 
          const find = await $('android=new UiSelector().text("PROJECT")')
          await find.click();
          // Back to get delete option
          const back2 = await $('android=new UiSelector().className("android.widget.ImageView").instance(0)').click();
          // click on three dots
          const dot = await $('android=new UiSelector().className("android.widget.ImageView").instance(3)')
          // scroll to Move to trash
          await driver.execute("mobile:scroll",{ direction: 'down' });
          const trash = await $('new UiSelector().className("android.view.ViewGroup").instance(256)');

          if (await trash.isDisplayed()) {
            await trash.click(); // Click the item after scrolling to it
        } else {
            console.log('Trash not found after scrolling.');
        }
       
    });
});