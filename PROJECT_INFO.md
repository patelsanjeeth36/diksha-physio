# Dr. Diksha Patel — Website Project Info
> Keep this file safe. All URLs, accounts, and how-to guides are here.

---

## Live Website URLs

| Platform | URL | Status |
|---|---|---|
| **GitHub Pages** (free, permanent) | `https://patelsanjeeth36.github.io/diksha-physio/` | Enable in GitHub settings (see below) |
| **Netlify** (free, faster) | Set up from GitHub (see below) | Not yet connected |

---

## All Accounts & Services

| Service | Account / Login | Purpose |
|---|---|---|
| **GitHub** | `patelsanjeeth36` · `patelsanjeeth36@gmail.com` | Hosts all code & the website files |
| **Neon.tech** | Sign in at https://console.neon.tech | Free PostgreSQL database (for Spring Boot backend) |
| **Render.com** | Connect via GitHub — https://render.com | Free Spring Boot hosting |
| **Web3Forms** | Use `diksha.physio.care@gmail.com` to sign up | Receives callback form submissions via email |
| **Google Maps** | Clinic link: `https://maps.app.goo.gl/ztBAom9FRBSogKLj8` | Map embed and directions link |

---

## Neon PostgreSQL Credentials

> Full credentials are stored locally in `.env` (never committed to GitHub).
> Use these values in Render.com → Environment tab.

| Variable | Value |
|---|---|
| `DB_URL` | `jdbc:postgresql://ep-young-math-ap4ycfu9-pooler.c-7.us-east-1.aws.neon.tech/neondb?sslmode=require` |
| `DB_USER` | `neondb_owner` |
| `DB_PASSWORD` | *(see `.env` file on your PC — do not write here)* |

Neon dashboard: https://console.neon.tech/app/projects
Project name: `diksha-physio`

---

## Dr. Diksha's Details (in the website)

| Field | Value |
|---|---|
| Name | Dr. Diksha Patel |
| Phone / WhatsApp | 9039411136 |
| Email | diksha.physio.care@gmail.com |
| Address | B2, Anand Kirti Apartment, Suhas Nagar, Thane East |
| Experience | 4+ years |
| Specialisation | Orthopaedic & Neurological Physiotherapy |
| Services | Online Consultation · Home Visits |

---

## Step 1 — Enable GitHub Pages (3 clicks, one-time)

1. Go to: https://github.com/patelsanjeeth36/diksha-physio/settings/pages
2. Under **Branch** → select `master` → folder `/docs`
3. Click **Save**
4. Wait ~2 minutes → site live at: `https://patelsanjeeth36.github.io/diksha-physio/`

---

## Step 2 — Set Up Web3Forms (callback form emails)

The callback form sends requests to Dr. Diksha's email via Web3Forms (free).

1. Go to: https://web3forms.com
2. Enter `diksha.physio.care@gmail.com` → click **Create Access Key**
3. Copy the Access Key (looks like: `abc12345-xxxx-xxxx-xxxx-xxxxxxxxxxxx`)
4. Edit `docs/config.json` on GitHub (see editing guide below)
5. In the `callbackForm` HTML (docs/index.html), replace `REPLACE_WITH_WEB3FORMS_KEY` with the key
   - File: `docs/index.html` → search for `REPLACE_WITH_WEB3FORMS_KEY`

---

## Step 3 (Optional) — Set Up Netlify (faster, custom domain ready)

Netlify is faster than GitHub Pages and supports custom domains on the free tier.

1. Go to: https://netlify.com → Sign up with GitHub
2. Click **New site from Git** → choose GitHub → select `diksha-physio` repo
3. Settings:
   - Build command: *(leave blank)*
   - Publish directory: `docs`
4. Click **Deploy** → live at `https://diksha-physio.netlify.app` (or custom name)
5. Every time you push to GitHub → Netlify auto-deploys in ~30 seconds

---

## How to Edit the Website (No Coding Needed)

### Method A — Edit config.json (for text, phone, bio, conditions, services)

The file `docs/config.json` controls all the editable content.

1. Go to: https://github.com/patelsanjeeth36/diksha-physio/blob/master/docs/config.json
2. Click the **pencil icon** (top right of the file)
3. Find the text you want to change and update it
4. Click **Commit changes** → add a short note like "Update phone number"
5. Wait ~2 minutes → website updates automatically

**What you can change in config.json:**
- Doctor name, phone, email, address
- Bio / About text
- Working hours
- Photo filename (if you upload a new photo)
- Services descriptions
- Ortho and neuro conditions list

### Method B — Change the Photo

1. Rename your new photo to `diksha-photo.jpeg` (must be JPEG)
2. Go to: https://github.com/patelsanjeeth36/diksha-physio/upload/master/docs
3. Drag and drop the new photo file
4. Click **Commit changes**
5. Wait ~2 minutes → photo updates on the website

If you want a different filename:
1. Upload the photo with any name (e.g., `diksha-new.jpeg`)
2. Edit `docs/config.json` → change `"photo": "diksha-photo.jpeg"` to `"photo": "diksha-new.jpeg"`
3. Commit → done

### Method C — Edit Any Other Text in the Page

1. Go to: https://github.com/patelsanjeeth36/diksha-physio/blob/master/docs/index.html
2. Click the **pencil icon**
3. Press `Ctrl+F` to search for the text you want to change
4. Update the text
5. Click **Commit changes**

---

## Key Files

| File | What It Does |
|---|---|
| `docs/index.html` | The website page |
| `docs/config.json` | **Edit this to update content** (name, phone, bio, services, conditions) |
| `docs/diksha-photo.jpeg` | Dr. Diksha's photo — replace this file to change the photo |
| `netlify.toml` | Netlify configuration |
| `Procfile` | For Render.com (if Spring Boot backend is needed later) |
| `src/` | Spring Boot backend (not used for the static site) |

---

## Google Maps

Direct link to clinic: https://maps.app.goo.gl/ztBAom9FRBSogKLj8

To embed a better map in the website:
1. Go to Google Maps → search the clinic address
2. Click Share → Embed a map → Copy HTML
3. Replace the `<iframe src="...">` in `docs/index.html` (search for "maps.google.com/maps")

---

## Conditions Currently Listed

### Orthopaedic
Lower Back Pain & Sciatica · Slip Disc / Disc Herniation · Cervical Spondylosis / Neck Pain
Knee Pain & Osteoarthritis · Knee Replacement Recovery · Hip Replacement Recovery
Frozen Shoulder · Sports Injuries & Ligament Tears · Post-Fracture Rehabilitation
Plantar Fasciitis / Heel Pain · Tennis Elbow / Golfer's Elbow · Scoliosis & Postural Correction

### Neurological
Stroke Rehabilitation (Hemiplegia) · Parkinson's Disease · Bell's Palsy / Facial Palsy
Cerebral Palsy · Spinal Cord Injury · Peripheral Neuropathy · Guillain-Barré Syndrome
Multiple Sclerosis · Vertigo & Balance Disorders · Post-COVID Neurological Recovery

*(To add/remove conditions: edit `docs/config.json` → `orthoConditions` or `neuroConditions` arrays)*

---

## Backup / Emergency

If the website goes down:
- Patients can always reach Dr. Diksha on **9039411136** (call/WhatsApp)
- Email: diksha.physio.care@gmail.com
- The code is always safe on GitHub: https://github.com/patelsanjeeth36/diksha-physio
