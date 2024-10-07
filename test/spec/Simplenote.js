describe('Simplenote', () => {
    
    it('Identify App Type', async() => {

        const context = await driver.getContext();

        console.log(context);
        
    });

    it('App', async() => {

        await driver.pause(5000);
         // Continue with log in
          const login = await $ ('android=new UiSelector().resourceId("com.automattic.simplenote:id/button_login")')
          await login.click();
        // Tap on Login Manually
          const log1 = await $('android=new UiSelector().resourceId("com.automattic.simplenote:id/sign_in_login_manually")')
          await log1.click();
        // Input Email
        const email = await $('android=new UiSelector().text("Email")');
        await email.setValue('sharmilabnkwb@gmail.com');
         // Input Password
        const pass = await $('android=new UiSelector().text("Password")')
        await pass.setValue('Simran2506');
        // Tap on LoginButton
        const button =  await $('android=new UiSelector().resourceId("com.automattic.simplenote:id/button")')
        await button.click();
        // Wait for the home page to load
        await driver.pause(5000);
        
         // Create a note
         const creation = await $('~New Note')
         await creation.click();
         // create one tag
         const tagn = await $('android=new UiSelector().resourceId("com.automattic.simplenote:id/tag_input")')
         await tagn.setValue('ConstructWeek3');
         await driver.pause(1000);
         // Start Writing
        //   const write = await $('android=new UiSelector().className("android.widget.LinearLayout").instance(3)')
        //   await write.setValue('Some Important Things.');
         // Navigate back 
         await driver.pressKeyCode(4);
         await driver.pause(1000);
         // Once Again back by using the back arrow icon
         const back0 = await $('android=new UiSelector().description("Navigate up")').click();
         // Search for notes
          const s1 = await $('android=new UiSelector().resourceId("com.automattic.simplenote:id/menu_search")')
          await s1.click();
          const s2 = await $('android=new UiSelector().resourceId("com.automattic.simplenote:id/search_src_text")')
          await s2.setValue('Cons');
         
          await $('android=new UiSelector().text("tag:ConstructWeek3")').click();
          await driver.pause(2000);
          // Assertion
          const week = await $('android=new UiSelector().resourceId("com.automattic.simplenote:id/note_title")');
          await expect(week).toBeExisting();
         
         // Once Again back by using the back arrow icon
         const back1 = await $('~Collapse')
         await back1.click();
          // Deleting the note 
          const find = await $('android=new UiSelector().text("Let us Work Hard")')
          await find.click();
           // click on three dots
          const back2 = await $('~More Options')
          await back2.click();
         // Get delete option
          const Trash = await $('android=new UiSelector().text("Trash")')
          await Trash.click();

         await driver.openNotifications();  // To access the notification
        // This will clear all notification
         await $('~Clear all notifications.').click();

         // Navigate To Home
         await driver.pressKeyCode(3);


       
    });
});