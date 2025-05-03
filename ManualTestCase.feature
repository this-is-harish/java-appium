Feature: Create Wallet Functionality in Trust Wallet

  Scenario: User successfully creates a new wallet
    Given the user launches the Trust Wallet app
    When the user taps on "Create New Wallet"
    And accepts the terms and conditions
    And sets a 6-digit passcode
    And confirms the passcode
    Then the wallet should be successfully created

  Scenario: User taps on "Create New Wallet" button
    Given the Trust Wallet home screen is displayed
    When the user taps on "Create New Wallet"
    Then the seed phrase setup screen should be displayed

  Scenario: User skips backup and proceeds
    Given the user is on the seed phrase screen
    When the user taps "Skip, I’ll do this later"
    Then a confirmation dialog should appear

  Scenario: User confirms skipping backup
    Given the confirmation dialog is displayed
    When the user confirms skip
    Then the wallet dashboard should be displayed

  Scenario: User rejects skipping backup
    Given the confirmation dialog is displayed
    When the user cancels skip
    Then the user should stay on the backup screen

  Scenario: User sets a weak passcode
    Given the user is on the passcode screen
    When the user enters "111111"
    Then a warning should be displayed about weak passcode

  Scenario: User sets and confirms mismatched passcodes
    Given the user is setting a passcode
    When the user enters "123456" and confirms with "654321"
    Then a mismatch error message should appear

  Scenario: User navigates back from passcode screen
    Given the user is on the passcode screen
    When the user presses back
    Then the app should return to the previous screen

  Scenario: User views seed phrase
    Given the user chooses to back up the wallet
    When the seed phrase is displayed
    Then it should show 12 words

  Scenario: User confirms seed phrase by selecting correct words
    Given the seed phrase words are shuffled
    When the user selects the correct order
    Then the wallet should be successfully backed up

  Scenario: User enters incorrect seed phrase order
    Given the user is verifying seed phrase
    When the user selects words in incorrect order
    Then an error message should be displayed

  Scenario: Wallet name defaults to "Main Wallet"
    Given a new wallet is created
    Then the wallet name should default to "Main Wallet"

  Scenario: App displays warning if seed phrase is screenshotted
    Given the seed phrase screen is visible
    When the user takes a screenshot
    Then a security warning should be displayed

  Scenario: App disables copy/paste on seed phrase
    Given the seed phrase screen is visible
    When the user attempts to copy the seed phrase
    Then the copy action should be blocked

  Scenario: Passcode screen shows number pad only
    Given the user is on the passcode screen
    Then only numeric keys should be visible

  Scenario: User tries to continue without accepting terms
    Given the user is on the terms screen
    When the user taps continue without checking the box
    Then an error should appear

  Scenario: Terms and conditions checkbox works
    Given the checkbox is unchecked
    When the user taps it
    Then the checkbox should become checked

  Scenario: App enforces minimum passcode length
    Given the passcode screen is displayed
    When the user enters fewer than 6 digits
    Then an error should be displayed

  Scenario: App masks passcode input
    Given the passcode screen is displayed
    When the user types digits
    Then the input should be masked with dots

  Scenario: App shows confirmation screen after passcode
    Given the user enters a passcode
    Then a confirm passcode screen should appear

  Scenario: User exits app mid-setup
    Given the user is on the seed phrase screen
    When the app is minimized and reopened
    Then the seed phrase screen should still be displayed

  Scenario: App resets progress on full exit
    Given the user kills the app during wallet creation
    When the app is reopened
    Then the user should start from the beginning

  Scenario: Wallet creation time is under 1 minute
    Given the user begins creating a wallet
    When the process completes
    Then it should finish within 1 minute

  Scenario: App creates a new wallet file on disk
    Given a wallet is created
    Then a wallet file should be stored in app data

  Scenario: Seed phrase is unique per wallet
    Given two wallets are created
    Then each seed phrase should be different

  Scenario: User can’t reuse old seed phrase
    Given a wallet was deleted
    When the user tries to use the same seed phrase
    Then the app should prompt for restore instead

  Scenario: App supports biometric after passcode set
    Given a passcode is successfully set
    When biometric prompt is enabled
    Then fingerprint or face recognition should be available

  Scenario: UI is responsive on different screen sizes
    Given the app is run on a tablet and phone
    Then all screens should be properly aligned

  Scenario: Wallet creation works with dark mode
    Given the device is in dark mode
    When the wallet is created
    Then UI elements should still be visible

  Scenario: User cannot create multiple wallets simultaneously
    Given the wallet is being created
    When the user tries to create another
    Then the app should block the action

  Scenario: Create wallet process handles network failure
    Given the user is creating a wallet
    When the network disconnects
    Then the process should still complete locally

  Scenario: Create wallet button is disabled after click
    Given the user taps "Create New Wallet"
    Then the button should be disabled to prevent double taps

  Scenario: App logs wallet creation event
    Given a wallet is created
    Then an event should be logged for analytics

  Scenario: User is reminded to back up after skipping
    Given the user skipped backup
    Then a reminder should be shown on the dashboard

  Scenario: Wallet creation doesn't affect existing wallets
    Given multiple wallets exist
    When a new wallet is created
    Then existing wallets remain unchanged

  Scenario: User can cancel wallet creation
    Given the wallet creation is in progress
    When the user taps "Cancel"
    Then the process should be aborted

  Scenario: Wallet creation works offline
    Given the device has no internet
    When the user creates a wallet
    Then the process should still succeed

  Scenario: Create wallet respects system font size
    Given the device font size is increased
    Then text should not overlap or truncate

  Scenario: Errors are localized per language setting
    Given the device is set to Spanish
    Then error messages during creation are shown in Spanish

  Scenario: App prevents screen recording on seed phrase
    Given the seed phrase screen is open
    Then screen recording should be blocked

  Scenario: App auto-logs out if idle on seed phrase screen
    Given the user is idle for 5 minutes
    Then the app should auto-lock

  Scenario: App requests confirmation before deleting created wallet
    Given the wallet was created
    When the user attempts deletion
    Then a confirmation popup should appear

  Scenario: App creates only one wallet at a time per user session
    Given the user creates a wallet
    When the process is finished
    Then the next wallet can be created

  Scenario: Wallet creation process shows progress indicator
    Given the wallet is being created
    Then a spinner or progress bar should be displayed

  Scenario: Keyboard does not cover input fields
    Given the passcode screen is displayed
    Then the keyboard should not obstruct any input

  Scenario: App handles orientation change gracefully
    Given the device is rotated during creation
    Then progress and layout should persist correctly
