# PicturePreview
Description

picture preview like a gallery.

Step 1. Add the JitPack repository to your build file

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Step 2. Add the dependency
  
  dependencies {
	        implementation 'com.github.jichangshuai:PicturePreview:0.9.6-beta.1'
	}
	
  Step 3. init and bind data source
  
  picturePreview = findViewById(R.id.picture_preview);
  picturePreview.setDataSource(Arrays.asList(source));
